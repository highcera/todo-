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
asset_tym_file_path = BOT_NAME + ".json"

try:
    with open(asset_tym_file_path, 'r') as json_file:
        Mon_log = json.load(json_file)

except Exception as e:
    print("Exception by First")
    
print(Mon_log)      

#만약 list가 비어있다면... 즉 처음 가동한다면
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
if IsMarketOpen & Monitoring_Go:                # 개장, 일 최초 요청
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
    
    
#     strResult = "-- 현재 포트폴리오 상황 --\n"

# #매수된 자산의 총합!
# total_stock_money = 0

# #현재 평가금액 기준으로 각 자산이 몇 주씩 매수해야 되는지 계산한다 (포트폴리오 비중에 따라) 이게 바로 리밸런싱 목표치가 됩니다.
# for stock_info in MyPortfolioList:

#     #내주식 코드
#     stock_code = stock_info['stock_code']
#     #매수할 자산 보유할 자산의 비중을 넣어준다!
#     stock_target_rate = float(stock_info['stock_target_rate']) 

#     #현재가!
#     CurrentPrice = KisUS.GetCurrentPrice(stock_code)
    
#     stock_name = ""
#     stock_amt = 0 #수량
#     stock_avg_price = 0 #평단
#     stock_eval_totalmoney = 0 #총평가금액!
#     stock_revenue_rate = 0 #종목 수익률
#     stock_revenue_money = 0 #종목 수익금

#     #내가 보유한 주식 리스트에서 매수된 잔고 정보를 가져온다
#     for my_stock in MyStockList:
#         if my_stock['StockCode'] == stock_code:
#             stock_name = my_stock['StockName']
#             stock_amt = int(my_stock['StockAmt'])
#             stock_avg_price = float(my_stock['StockAvgPrice'])
#             stock_eval_totalmoney = float(my_stock['StockNowMoney'])
#             stock_revenue_rate = float(my_stock['StockRevenueRate'])
#             stock_revenue_money = float(my_stock['StockRevenueMoney'])
#             break
#          stock_info['stock_rebalance_amt'] = -GapAmt
        
#     print("##### stock_code: ", stock_code)

#     #주식의 총 평가금액을 더해준다
#     total_stock_money += stock_eval_totalmoney

#     #현재 비중
#     stock_now_rate = 0

#     #잔고에 있는 경우 즉 이미 매수된 주식의 경우
#     if stock_amt > 0:
#         stock_now_rate = round((stock_eval_totalmoney / TotalMoney),3)
#         print("---> NowRate:", round(stock_now_rate * 100.0,2), "%")

#         #목표한 비중이 다르다면!!
#         if stock_now_rate != stock_target_rate:

#             #갭을 구한다!!!
#             GapRate = stock_target_rate - stock_now_rate

#             #그래서 그 갭만큼의 금액을 구한다
#             GapMoney = TotalMoney * abs(GapRate) 
#             #현재가로 나눠서 몇주를 매매해야 되는지 계산한다
#             GapAmt = GapMoney / CurrentPrice

#             #수량이 1보다 커야 리밸러싱을 할 수 있다!! 즉 그 전에는 리밸런싱 불가 
#             if GapAmt >= 1.0:
#                 GapAmt = int(GapAmt)

#                 #갭이 음수라면! 비중이 더 많으니 팔아야 되는 상황!!! 
#                 if GapRate < 0:
#                     print("this!!!")
                    
#                     stock_info['stock_rebalance_amt'] = -GapAmt

#                 #갭이 양수라면 비중이 더 적으니 사야되는 상황!
#                 else:  
#                     stock_info['stock_rebalance_amt'] = GapAmt

#     #잔고에 없는 경우
#     else:
#         print("---> NowRate: 0%")

#         #잔고가 없다면 첫 매수다! 비중대로 매수할 총 금액을 계산한다 
#         BuyMoney = TotalMoney * stock_target_rate

#         #매수할 수량을 계산한다!
#         BuyAmt = int(BuyMoney / CurrentPrice)

#         #if BuyAmt <= 0:
#         #    BuyAmt = 1

#         stock_info['stock_rebalance_amt'] = BuyAmt











#     # 모든 자산의 일별 rate 저장 
#     rates = list()
#     for stock_info in MyPortfolioList:
#         # print("%s : %0.2f" %(stock_info['stock_code'], stock_info['stock_target_rate']))
#         rates.append(stock_info['stock_target_rate'])   
#     # print(rates)

#     # 파일이 없는 경우 이전과 비교X
#     if Comparision_Go :
#         if Mon_log[-1]['rates'] == rates:
#             print("변동없음")
#             line_alert.SendMessage(PortfolioName + " (" + strYMD + ") 변동사항 없음!!")
#         else: 
#             print("변동발생! 강제 리벨런싱 필요!!")      
#             line_alert.SendMessage(PortfolioName + " (" + strYMD + ") 리밸런싱 필요!!")
    
#     asset = dict()
#     asset['date'] = strYMD
#     asset['rates'] = rates
    
#     Mon_log.append(asset)   

#     with open(asset_tym_file_path, 'w') as outfile:
#         json.dump(Mon_log, outfile)
         
# else:
#     print("Market Is Closed or multiple Request... Monitoring pass!!")
#     line_alert.SendMessage(PortfolioName + " (" + strYMD + ") 장이 닫혀있거나 다차 요청이라서 모니터링 패스!!")