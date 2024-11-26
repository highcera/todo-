# 관련 포스팅 https://blog.naver.com/zacra/223287362804

import KIS_Common as Common
import KIS_API_Helper_US as KisUS
import time
import json
import pprint

from datetime import datetime
from pytz import timezone

import line_alert
   
#계좌 선택.. "VIRTUAL" 는 모의 계좌!
Common.SetChangeMode("VIRTUAL") #REAL or VIRTUAL
BOT_NAME = Common.GetNowDist() + "_MySimplePowerBotUs2_Mon"

#시간 정보를 읽는다
time_info = time.gmtime()

strYMD = str(time_info.tm_year) + "_" + str(time_info.tm_mon)+ "_" + str(time_info.tm_mday)

#포트폴리오 이름
PortfolioName = "심플파워전략_US2_Mon"

#파일에 저장된 Monitoring용 일별 data를 읽는다.
Mon_log = list()
Comparision_Go = True
Monitoring_Go = True

#파일 경로입니다.
asset_tym_file_path = "/var/autobot/" + BOT_NAME + ".json"

try:
    with open(asset_tym_file_path, 'r') as json_file:
        Mon_log = json.load(json_file)

except Exception as e:
    print("Exception by First")
    
print(Mon_log)      

#만약 키가 존재 하지 않는다. 즉 처음 가동한다면
if Mon_log == []: 
    Comparision_Go = False

#매매 log 파일이 있다면
else:
    #하루에 한번 monitoring 하지 않는 경우 (강제 실행 등) 
    if Mon_log[-1].get('date') == strYMD:
        # print(Mon_log[-1].get('date'), type(Mon_log[-1].get('date')))
        #Monitoring pass!
        Monitoring_Go = False
  
#마켓이 열렸는지 여부~!
IsMarketOpen = KisUS.IsMarketOpen()

# if (not IsMarketOpen) & (not Monitoring_Go):    # 휴장, 일일 복수 요청
# if (not IsMarketOpen) & Monitoring_Go:          # 휴장, 일 최초 요청
# if IsMarketOpen & (not Monitoring_Go):          # 일일 복수 요청
if IsMarketOpen & Monitoring_Go:
    print("Market Is Open! Monitoring is going on!!")
          
    #투자 주식 리스트
    MyPortfolioList = list()

    StockCodeList = ["TQQQ","SCHD","PFIX","TMF"]

    for stock_code in StockCodeList:
        asset = dict()
        asset['stock_code'] = stock_code         #종목코드

        if stock_code == "TQQQ":                  # ProShares UltraPro QQQ
            asset['stock_target_rate'] = 0.5
        elif stock_code == "SCHD":
            asset['stock_target_rate'] = 0.2
        elif stock_code == "PFIX":                # Simplify Interest Rate Hedge ETF
            asset['stock_target_rate'] = 0.15
        elif stock_code == "TMF":                 # Direxion Daily 20+ Year Treasury Bull 3X Shares
            asset['stock_target_rate'] = 0.15

        asset['stock_rebalance_amt'] = 0     #리밸런싱 해야 되는 수량
        MyPortfolioList.append(asset)

    PFIX_OUT = False
    TMF_OUT = False

    #모든 자산의 모멘텀 스코어 구하기! 
    for stock_info in MyPortfolioList:
        # print("....")
        stock_code = stock_info['stock_code']

        df = Common.GetOhlcv("US",stock_code)

        prevClose = df['close'].iloc[-2]

        Ma130_Before = Common.GetMA(df,130,-3)
        Ma130 = Common.GetMA(df,130,-2)

        Rate = 1.0    
        CutCnt = 0
        Above_ma = "above"
        Trend_up = "up"

        if Ma130 > prevClose:
            Rate *= 0.5
            CutCnt += 1
            Above_ma = "below"

        if Ma130_Before > Ma130:
            Rate *= 0.5
            CutCnt += 1
            Trend_up = "down"

        TargetRate = stock_info['stock_target_rate']
            
        if CutCnt == 2 and stock_code in ['PFIX','TMF']:
            Rate = 0
            if stock_code == "PFIX":
                PFIX_OUT = True
            elif stock_code == "TMF":
                TMF_OUT = True

        stock_info['stock_target_rate'] = TargetRate * Rate
        
        print(stock_code," -> 투자 비중: ", stock_info['stock_target_rate'] * 100.0, "%")
        print("Go? : %s, Trend up? : %s" %(Above_ma, Trend_up))
        print("Ma130_Before : %0.2f, Ma130 : %0.2f, prevClose : %0.2f, CutCnt : %d" %(Ma130_Before, Ma130, prevClose, CutCnt))
        
    #PFIX     
    if PFIX_OUT == True and TMF_OUT == False:
        for stock_info in MyPortfolioList:
            stock_code = stock_info['stock_code'] 
            
            if stock_code == "TMF":
                stock_info['stock_target_rate'] *= 2.0
                                    
                print(stock_code," -> 투자 정정 비중: ", stock_info['stock_target_rate'] * 100.0, "%")
                break
        
    if PFIX_OUT == False and TMF_OUT == True:
        for stock_info in MyPortfolioList:
            stock_code = stock_info['stock_code'] 
            
            if stock_code == "PFIX":
                stock_info['stock_target_rate'] *= 2.0
                
                print(stock_code," -> 투자 정정 비중: ", stock_info['stock_target_rate'] * 100.0, "%")
                break

    # 모든 자산의 일별 rate 저장 
    rates = list()
    for stock_info in MyPortfolioList:
        # print("%s : %0.2f" %(stock_info['stock_code'], stock_info['stock_target_rate']))
        rates.append(stock_info['stock_target_rate'])   
    # print(rates)

    # 파일이 없는 경우 이전과 비교X
    if Comparision_Go :
        if Mon_log[-1]['rates'] == rates:
            print("변동없음")
            line_alert.SendMessage(PortfolioName + " (" + strYMD + ") 변동사항 없음!!")
        else: 
            print("변동발생! 강제 리벨런싱 필요!!")      
            line_alert.SendMessage(PortfolioName + " (" + strYMD + ") 리밸런싱 필요!!")
    
    asset = dict()
    asset['date'] = strYMD
    asset['rates'] = rates
    
    Mon_log.append(asset)   

    with open(asset_tym_file_path, 'w') as outfile:
        json.dump(Mon_log, outfile)
         
else:
    print("Market Is Closed or multiple Request... Monitoring pass!!")
    line_alert.SendMessage(PortfolioName + " (" + strYMD + ") 장이 닫혀있거나 다차 요청이라서 모니터링 패스!!")