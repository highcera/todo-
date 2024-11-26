# https://blog.naver.com/zacra/223419399142

import KIS_Common as Common
import pandas as pd
import KIS_API_Helper_US as KisUS
import time
import json
import pprint
from datetime import datetime, timedelta

import line_alert

#계좌 선택.. "VIRTUAL" 는 모의 계좌!
Common.SetChangeMode("VIRTUAL") #REAL or VIRTUAL

BOT_NAME = Common.GetNowDist() + "_MySnowNBotUS_Mon"

#시간 정보를 읽는다
time_info = time.gmtime()

strYMD = str(time_info.tm_year) + "_" + str(time_info.tm_mon)+ "_" + str(time_info.tm_mday)

#포트폴리오 이름
PortfolioName = "Snow전략_US_Mon"

# 로그 파일을 연다.
Mon_log = list()
Comparision_Go = True
Monitoring_Go = True

#파일 경로입니다.
asset_tym_file_path =  "/var/autobot/" + BOT_NAME + ".json"

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

    StockCodeList = ["TIP","SPTL","VGIT","PFIX","RISR","USHY","VCIT","VWOB","BNDX","BWX","SGOV","UPRO","TYD","VNQ","PDBC"]
    # 비교 : TIP 
    # 안전 : TIP, SPTL, VGIT, PFIX, RISR, USHY, VCIT, VWOB, BNDX, BWX, SGOV 
    # 공격 : UPRO, TYD, VNQ, PDBC
     
    for stock_code in StockCodeList:
        asset = dict()
        asset['stock_code'] = stock_code         #종목코드
        asset['stock_target_rate'] = 0     #비중..
        asset['stock_rebalance_amt'] = 0  #리밸런싱 수량
        MyPortfolioList.append(asset)

    # print("--------------내 보유 주식---------------------")
    # #그리고 현재 이 계좌에서 보유한 주식 리스트를 가지고 옵니다!
    # MyStockList = KisUS.GetMyStockList()
    # pprint.pprint(MyStockList)
    # print("--------------------------------------------")

    # print("--------------리밸런싱 계산 ---------------------")

    stock_df_list = []

    for stock_code in StockCodeList:  
        df = Common.GetOhlcv("US", stock_code,300) 

        df['prevClose'] = df['close'].shift(1)

        df['1month'] = df['close'].shift(20)
        df['3month'] = df['close'].shift(60)
        df['5month'] = df['close'].shift(100)
        df['6month'] = df['close'].shift(120)
        df['9month'] = df['close'].shift(180)
        df['12month'] = df['close'].shift(240)

        #1개월 수익률 + 3개월 수익률 + 6개월 수익률 + 9개월 수익률 + 12개월 수익률
        df['Momentum'] = ( ((df['prevClose'] - df['1month'])/df['1month']) + ((df['prevClose'] - df['3month'])/df['3month']) + ((df['prevClose'] - df['6month'])/df['6month']) + ((df['prevClose'] - df['9month'])/df['6month'])  + ((df['prevClose'] - df['12month'])/df['12month']) ) / 5.0
        
        #1개월 수익률 x 12 + 3개월 수익률 x 4 + 6개월 수익률 x 2 + 12개월 수익률
        df['MomentumGA'] = (((df['prevClose'] - df['1month'])/df['1month']) * 12.0) + (((df['prevClose'] - df['3month'])/df['3month']) * 4.0) + (((df['prevClose'] - df['6month'])/df['6month']) *2.0 ) + ((df['prevClose'] - df['12month'])/df['12month'])
        
        #6개월 모멘텀
        df['Momentum_6'] = (df['prevClose'] - df['6month'])/df['6month']

        df.dropna(inplace=True) #데이터 없는건 날린다!

        data_dict = {stock_code: df}
        stock_df_list.append(data_dict)
            
        print("---stock_code---", stock_code , " len ",len(df))
        # pprint.pprint(df)
        # pprint.pprint(stock_df_list)

    combined_df = pd.concat([list(data_dict.values())[0].assign(stock_code=stock_code) for data_dict in stock_df_list for stock_code in data_dict])
    combined_df.sort_index(inplace=True)
    # pprint.pprint(combined_df)
    # print(" len(combined_df) ", len(combined_df))

    # # Write DataFrame to CSV without Header
    # combined_df.to_csv("combined_df2.csv")

    date = combined_df.iloc[-1].name
    # print(date)

    tip_data = combined_df[(combined_df.index == date) & (combined_df['stock_code'] == "TIP")] 
    print(tip_data, type(tip_data))

    #안전자산을 제외한 공격자산의 모멘텀 높은거 1개 픽!!!!
    exclude_stock_codes = ["TIP","SPTL","VGIT","PFIX","RISR","USHY","VCIT","VWOB","BNDX","BWX","SGOV"] #공격자산에 포함되면 안되는 종목들 즉 안전자산들을 넣으면 된다!
    pick_momentum_top = combined_df.loc[(combined_df.index == date)  & (~combined_df['stock_code'].isin(exclude_stock_codes)) ].groupby('stock_code')['MomentumGA'].max().nlargest(1)
    # print("공격자산 모멘텀 상위 1종 : ", pick_momentum_top, type(pick_momentum_top))


    #공격자산을 제외한 안전자산 모멘텀 스코어가 높은거 상위 TOP 3개를 리턴!
    exclude_stock_codes = ["UPRO","TYD","VNQ","PDBC"] #안전자산에 포함되면 안되는 종목들 즉 공격자산들을 넣으면 된다!
    pick_bond_momentum_top = combined_df.loc[(combined_df.index == date) & (~combined_df['stock_code'].isin(exclude_stock_codes))].groupby('stock_code')['Momentum_6'].max().nlargest(3)
    # print("안전자산 모멘텀 상위 3종 : ", pick_bond_momentum_top, type(pick_bond_momentum_top))

    if len(tip_data) == 1 :
        #안전 자산 비중 정하기!
        SafeRate = 0
        AtkRate = 0
            
        AtkOkList = list()
        SafeOkList = list()
        
        #TIP 모멘텀 양수 장이 좋다!
        if tip_data['Momentum'].values[0] > 0 :
            
            #공격자산에 100% 투자한다!
            AtkRate = 1.0
            for stock_code in pick_momentum_top.index:
                stock_data = combined_df[(combined_df.index == date) & (combined_df['stock_code'] == stock_code)]

                if len(stock_data) == 1:
                    AtkOkList.append(stock_code)

        #TIP 모멘텀 음수 장이 안좋아!
        else:
            #안전자산에 100% 투자한다!
            SafeRate = 1.0

        #리밸런싱 수량을 확정한다!
        for stock_info in MyPortfolioList:
            stock_code = stock_info['stock_code']
            stock_data = combined_df[(combined_df.index == date) & (combined_df['stock_code'] == stock_code)] 
            
            if len(stock_data) == 1:  
                IsRebalanceGo = False
                NowClosePrice = stock_data['close'].values[0]

                #안전 자산 비중이 있는 경우!! 안전자산에 투자!!!
                if SafeRate > 0:
                    for stock_code_b in pick_bond_momentum_top.index:   
                        if stock_code_b == stock_code:
                            if stock_data['Momentum_6'].values[0] > 0 :
                                stock_info['stock_target_rate'] += (SafeRate/len(pick_bond_momentum_top.index))
                                print("방어자산! ", stock_code, stock_info['stock_target_rate'])
                                SafeOkList.append(stock_code_b)
                            break

                #선택된 공격자산이라면!!
                if stock_code in AtkOkList:
                    stock_info['stock_target_rate'] +=  (AtkRate/len(pick_momentum_top.index))
                    print("공격자산! ", stock_code, stock_info['stock_target_rate'])    
       
    # 모든 자산의 일별 rate 저장 
    rates = list()
    for stock_info in MyPortfolioList:
        # print("%s : %0.2f" %(stock_info['stock_code'], stock_info['stock_target_rate']))
        rates.append(stock_info['stock_code'])
        rates.append(stock_info['stock_target_rate'])   
    print(rates)

    tip_mmt = tip_data['Momentum'].values[0]
    # print(tip_mmt, type(tip_mmt), SafeRate, AtkRate, AtkOkList, SafeOkList)
    
    asset = dict()
    asset['date'] = strYMD
    if tip_mmt > 0:
        asset['status'] = 'Attack'
        asset['Codes'] = AtkOkList
    else:
        asset['status'] = 'Safe'
        asset['Codes'] = SafeOkList
    # asset['rates'] = rates
    Mon_log.append(asset)   
if Mon_log[-1].get('date') == strYMD:
    # 파일이 없는 경우 이전과 비교X
    if Comparision_Go :
        if (Mon_log[-2].get('status') == Mon_log[-1].get('status')) & (Mon_log[-2].get('Codes') == Mon_log[-1].get('Codes')):
            print("변동없음")
            line_alert.SendMessage(PortfolioName + " (" + strYMD + ") 변동사항 없음!!")
        else: 
            print("변동발생! 강제 리벨런싱 필요!!")      
            line_alert.SendMessage(PortfolioName + " (" + strYMD + ") 리밸런싱 필요!!") 
      
    with open(asset_tym_file_path, 'w') as outfile:
        json.dump(Mon_log, outfile)
         
else:
    print("Market Is Closed or multiple Request... Monitoring pass!!")
    line_alert.SendMessage(PortfolioName + " (" + strYMD + ") 장이 닫혀있거나 다차 요청이라서 모니터링 패스!!") 
