import KIS_Common as Common
import pandas as pd
import KIS_API_Helper_US as KisUS
import time
import pprint
import json
import line_alert

#계좌 선택.. "VIRTUAL" 는 모의 계좌!
Common.SetChangeMode("REAL") #REAL or VIRTUAL

#시간 정보를 읽는다
time_info = time.gmtime()

#정보리스트와 차수를 받아서 차수 정보(익절기준,진입기준)을 리턴한다!
def GetSplitMetaInfo(DataList, number):
    PickSplitMeta = None
    for infoData in DataList:
        if number == infoData["number"]:
            PickSplitMeta =  infoData
            break 
    return PickSplitMeta

#파일로 저장관리되는 데이터를 읽어온다(진입가,진입수량)
def GetSplitDataInfo(DataList, number):
    PickSplitData = None
    for saveData in DataList:
        if number == saveData["Number"]:
            PickSplitData =  saveData
            break        
    return PickSplitData

BOT_NAME = Common.GetNowDist() + "_UJOJ_US"

#계좌 잔고를 가지고 온다!
Balance = KisUS.GetBalance()

print("--------------내 보유 잔고---------------------")
pprint.pprint(Balance)
print("--------------------------------------------")

#총 평가금액에서 해당 봇에게 할당할 총 금액비율 1.0 = 100%  0.5 = 50%
InvestRate = 0.9

#기준이 되는 내 총 평가금액에서 투자비중을 곱해서 나온 포트폴리오에 할당된 돈!!
TotalMoney = float(Balance['TotalMoney']) * InvestRate
print("총 포트폴리오에 할당된 투자 가능 금액 : $", TotalMoney)

TargetStockList = list()

TargetStockList.append({"stock_code":"TQQQ", "small_ma":4 , "big_ma":53, "invest_rate":1}) 
TargetStockList.append({"stock_code":"QLD", "small_ma":5, "big_ma":55, "invest_rate":0}) 
TargetStockList.append({"stock_code":"QQQ", "small_ma":7, "big_ma":165, "invest_rate":0}) 
### invest rate 가변 수정 필요, 일단 TQQQ 100% 

DivNum = 4.0

if time_info.tm_hour in [0,1] and time_info.tm_min in [0,1]:
    time.sleep(20.0)

#차수 정보가 들어간 데이터 리스트!
InvestInfoDataList = list()

for stock_data in TargetStockList: 
    stock_code = stock_data['stock_code']
    TotalInvestMoney = TotalMoney * stock_data['invest_rate']
    
    DivNum = 4 # 1차수 매수후 2차수부터 추가하락 후 CDMA GC 4차수까지 추가 매수
    
    SplitInfoList = list()
    
    # 4 3 2 1 로 할당...
    for i in range(int(DivNum)):      
        SplitInfoList.append({"number":i+1, "invest_money":round(TotalInvestMoney*(4-i)/10)}) #차수, 목표수익률, 매수기준 손실률 (1차수는 이 정보가 필요 없다),투자금액
 
    InvestInfoDict = dict()
    InvestInfoDict['stock_code'] = stock_code
    InvestInfoDict['small_ma'] = stock_data['small_ma']
    InvestInfoDict['big_ma'] = stock_data['big_ma']
    InvestInfoDict['split_info_list'] = SplitInfoList
    InvestInfoDict['sell_ratio_list'] = [{"number":1, "sell_ration":0.1}, {"number":2, "sell_ration":0.2}, {"number":3, "sell_ration":0.3}, {"number":4, "sell_ration":0.4}]
    InvestInfoDataList.append(InvestInfoDict)
      
pprint.pprint(InvestInfoDataList)

############# 매수후 진입시점, 수익률 등을 저장 관리할 파일 ####################
File_MND_List = list()
#파일 경로입니다.
bot_file_path = "/var/autobot/" + BOT_NAME + ".json"
# bot_file_path = BOT_NAME + ".json"

try:
    #이 부분이 파일을 읽어서 리스트에 넣어주는 로직입니다. 
    with open(bot_file_path, 'r') as json_file:
        File_MND_List = json.load(json_file)

except Exception as e:
    print("Exception by First")

print("--------------내 보유 주식---------------------")
#그리고 현재 이 계좌에서 보유한 주식 리스트를 가지고 옵니다!
AccStockList = KisUS.GetMyStockList()
pprint.pprint(AccStockList)
print("--------------------------------------------")

#마켓이 열렸는지 여부~!
IsMarketOpen = KisUS.IsMarketOpen()

IsLP_OK = True
#정각 9시 5분 전에는 LP유동성 공급자가 없으니 매매를 피하고자.
if time_info.tm_hour == 0: #9시인데
    if time_info.tm_min < 6: #6분보다 적은 값이면 --> 6분부터 LP가 활동한다고 하자!
        IsLP_OK = False

#장이 열렸고 LP가 활동할때 매수!!!
if IsMarketOpen != True: # and IsLP_OK != True: 
    print("매매 가능")

    #투자할 종목을 순회한다!
    for InvestInfo in InvestInfoDataList:
        stock_code = InvestInfo['stock_code'] #종목 코드
        
        ma1 = InvestInfo['small_ma']
        ma2 = InvestInfo['big_ma']

        small_ma_ = int(ma1)
        big_ma_ = int(ma2)   
        
        df = Common.GetOhlcv("US", stock_code,300)
        df['prevClose'] = df['close'].shift(1)
        
        date = df.iloc[-1].name
        stock_data = df[(df.index == date)]
        
        prev_close = stock_data['prevClose'].values[0]
        
        # 이동평균선값을 구해줍니다!
        small_ma_before = Common.GetMA(df, small_ma_, -2) #이전캔들의 small_MA 
        small_ma = Common.GetMA(df, small_ma_, -1) #현재캔들의 small_MA 
        
        big_ma_before = Common.GetMA(df, big_ma_, -2) #이전캔들의 small_MA 
        big_ma = Common.GetMA(df, big_ma_, -1) #현재캔들의 small_MA 
        
        ma120_before =  Common.GetMA(df, 120, -2) #이전캔들의 120MA
        ma120 =  Common.GetMA(df, 120, -1) #현재캔들의 120MA
        
        ma60_before =  Common.GetMA(df, 60, -2) #이전캔들의 60MA
        ma60 =  Common.GetMA(df, 60, -1) #현재캔들의 60MA
        
        ma20_before =  Common.GetMA(df, 20, -2) #이전캔들의 20MA
        ma20 =  Common.GetMA(df, 20, -1) #현재캔들의 20MA
        
        ma10_before =  Common.GetMA(df, 10, -2) #이전캔들의 10MA
        ma10 =  Common.GetMA(df, 10, -1) #현재캔들의 10MA
        
        dic = [
            {'name':'ma120_before', 'value':ma120_before},
            {'name':'ma60_before', 'value':ma60_before},
            {'name':'ma20_before', 'value':ma20_before},
            {'name':'ma10_before', 'value':ma10_before},
            {'name':'prev_close', 'value':prev_close}
            ]
        
        # [이동평균선 대체 고려]
        # MACD값을 구해줍니다!
        macd_before = Common.GetMACD(df,-2) #이전캔들의 MACD
        macd = Common.GetMACD(df,-1) #현재캔들의 MACD
        print(macd_before, macd)
        
        # 딕셔너리의 value 키 값을 기준으로 내림차순 정렬
        print("[전일 종가 및 이평선 위치 확인]")
        sorted_dic = sorted(dic, key = lambda x:x['value'], reverse=True) 
        for ma in sorted_dic:
            print(ma['name'], " : ", ma['value']) 
    
        print("[V2_MA 기준 지표]")
        if small_ma_before > big_ma_before:
            print("매도시점 모니터링")
            if macd_before['macd'] > macd_before['macd_siginal'] and macd['macd'] < macd['macd_siginal']:
                print("MACD DC 발생! 차수별 매도 비율 적용 매도 진행")
            else:
                print("매도 신호 미발생")    
        else:
            print("매수시점 모니터링")
            if macd_before['macd'] < macd_before['macd_siginal'] and macd['macd'] > macd['macd_siginal']: 
                print("MACD GC 발생! 매수 진행")
            else:
                print("매수 신호 미발생")    
      
        print("[MACD 기준 지표]")
        if macd_before["macd"] > 0:
            print("매도시점 모니터링")
            if macd_before["macd"] > macd_before["macd_siginal"] and macd["macd"] < macd["macd_siginal"]:
                print("MACD DC 발생! 차수별 매도 비율 적용 매도 진행")
            else:
                print("매도 신호 미발생")    
        else:
            print("매수시점 모니터링")
            if macd_before["macd"] < macd_before["macd_siginal"] and macd["macd"] > macd["macd_siginal"]:
                print("MACD GC 발생! 매수 진행")
            else:
                print("매수 신호 미발생")    
            
            
        # RSI값을 구해줍니다!
        rsi_before = Common.GetRSI(df,14,-2) #이전캔들의 RSI
        rsi = Common.GetRSI(df,14,-1) #현재캔들의 RSI
        
        print("[RSI 지표]")
        if rsi_before < 30:
            print("과매도")
        elif rsi_before >70:
            print("과매수")
        else:
            print("정상")
            
        
        print("small before : ", small_ma_before, ", small : ", small_ma, ", big before : ", big_ma_before, ", big : ", big_ma)
        print("120 before : ", ma120_before, ", 60 before : ", ma60_before, ", 20 before : ", ma20_before)
        print("120 : ", ma120, ", 60 : ", ma60, ", 20 : ", ma20)
        print("rsi_before : ", rsi_before, ", rsi : ", rsi)
        print("macd : ", macd)
  
        stock_amt = 0 #수량

        #내가 보유한 주식 리스트에서 매수된 잔고 정보를 가져온다
        for my_stock in AccStockList:
            if my_stock['StockCode'] == stock_code:
                stock_amt = int(my_stock['StockAmt'])
                break

        #종목 정보~
        stock_amt = 0 #수량
        stock_avg_price = 0 #평단
        stock_eval_totalmoney = 0 #총평가금액!
        stock_revenue_rate = 0 #종목 수익률
        stock_revenue_money = 0 #종목 수익금

        #매수된 상태라면 정보를 넣어준다!!!
        for my_stock in AccStockList:
            if my_stock['StockCode'] == stock_code:
                stock_amt = int(my_stock['StockAmt'])
                stock_avg_price = float(my_stock['StockAvgPrice'])
                stock_eval_totalmoney = float(my_stock['StockNowMoney'])
                stock_revenue_rate = float(my_stock['StockRevenueRate'])
                stock_revenue_money = float(my_stock['StockRevenueMoney'])
                break

        #현재가
        CurrentPrice = KisUS.GetCurrentPrice(stock_code)
        

        #종목 데이터
        PickMagicDataInfo = None

        #저장된 종목 데이터를 찾는다
        for MagicDataInfo in File_MND_List:
            if MagicDataInfo['StockCode'] == stock_code:
                PickMagicDataInfo = MagicDataInfo
                break

        #PickMagicDataInfo 이게 없다면 매수되지 않은 처음 상태이거나 이전에 손으로 매수한 종목인데 해당 봇으로 돌리고자 할 때!
        if PickMagicDataInfo == None:
            MagicNumberDataDict = dict()
            MagicNumberDataDict['StockCode'] = stock_code #종목 코드
            MagicNumberDataDict['IsReady'] = bool(True) #오늘 장에서 매수 가능한지 플래그!

            MagicDataList = list()
            
            #사전에 정의된 데이터!
            for i in range(len(InvestInfo['split_info_list'])):
                MagicDataDict = dict()
                MagicDataDict['Number'] = i+1 # 차수
                MagicDataDict['EntryPrice'] = 0 #진입가격
                MagicDataDict['EntryAmt'] = 0   #진입수량
                MagicDataDict['IsBuy'] = bool(False)  #매수 상태인지 여부
                
                MagicDataList.append(MagicDataDict)

            MagicNumberDataDict['MagicDataList'] = MagicDataList
            MagicNumberDataDict['RealizedPNL'] = 0 #종목의 누적 실현손익

            File_MND_List.append(MagicNumberDataDict) #데이터를 추가 한다!

            msg = stock_code + " 스마트스플릿 투자 준비 완료!!!!!"
            print(msg) 
            line_alert.SendMessage(msg) 

            #파일에 저장
            with open(bot_file_path, 'w') as outfile:
                json.dump(File_MND_List, outfile)        

#=====================================================================================================================
        #이제 데이터(File_MND_List)는 확실히 있을 테니 본격적으로 트레이딩을 합니다!
        if macd_before["macd"] > 0:
            print("매도시점 모니터링")
            if macd_before["macd"] > macd_before["macd_siginal"] and macd["macd"] < macd["macd_siginal"]:
                print("MACD DC 발생! 차수별 매도 비율 적용 매도 진행")
                # 최종 매수된 차수가 부터 매도, 1차수는 남김
                ##################################################################################################       
                for MagicDataInfo in File_MND_List:          
                    if MagicDataInfo['StockCode'] == stock_code:
                        # 매수한 최종 차수 구하기
                        find_step = DivNum
                                                  
                        MagicDataList = MagicDataInfo["MagicDataList"]
                        
                        IsOver = False

                        for div in range(int(DivNum), 0, -1):
                            # print(div, MagicDataList[div-1]["IsBuy"])
                            if MagicDataList[div-1]["IsBuy"] == True:
                                if div != 1 and div != 2:
                                    SellAmt = MagicDataList[div-1]["EntryAmt"]
                                    print(SellAmt)
                                    
                                    #만약 매도할 수량이 수동 매도등에 의해서 보유 수량보다 크다면 보유수량으로 정정해준다!
                                    if SellAmt > stock_amt:
                                        SellAmt = stock_amt
                                        IsOver = True
                                
                                    # pprint.pprint(KisUS.MakeSellLimitOrder(stock_code,SellAmt,CurrentPrice*0.99))
                                    print("매도처리 : ", SellAmt)
                                find_step = div
                                break
                            
                        print("현재 차수 : ", find_step) 
                        
                        MagicData['IsBuy'] = False
                        MagicDataInfo['RealizedPNL'] += (stock_revenue_money * SellAmt/stock_amt)

                        msg = stock_code + " 옹줍오즐 "+str(find_step)+"차 일부 매도 완료!"   ### 검증 필요!!!
                        
                        if IsOver == True:
                            msg = stock_code + " 옹줍오즐 매도할 수량이 보유 수량보다 많은 상태라 모두 매도함!" 
                            
                        print(msg) 
                        line_alert.SendMessage(msg)

                        #1차수 매도라면 레디값을 False로 바꿔서 오늘 1차 매수가 없도록 한다!
                        if MagicData['Number'] == 1:
                            MagicDataInfo['IsReady'] = False

                        #파일에 저장
                        with open(bot_file_path, 'w') as outfile:
                            json.dump(File_MND_List, outfile)
                            
                        #매매가 일어났으니 보유수량등을 리프레시 한다!
                        AccStockList = KisUS.GetMyStockList()
                        #매수된 상태라면 정보를 넣어준다!!!
                        for my_stock in AccStockList:
                            if my_stock['StockCode'] == stock_code:
                                stock_amt = int(my_stock['StockAmt'])
                                stock_avg_price = float(my_stock['StockAvgPrice'])
                                stock_eval_totalmoney = float(my_stock['StockNowMoney'])
                                stock_revenue_rate = float(my_stock['StockRevenueRate'])
                                stock_revenue_money = float(my_stock['StockRevenueMoney'])
                                break                                                    
            else:
                print("매도 신호 미발생")    
        else:
            print("매수시점 모니터링")                                        
            if CurrentPrice < ma120 and macd_before["macd"] < macd_before["macd_siginal"] and macd["macd"] > macd["macd_siginal"]:
                # 120일 이평, 60일 이평 GC 검토 필요
                print("현재가 120 이평선 이하, MACD GC 발생!!")  
                for MagicDataInfo in File_MND_List:          
                    if MagicDataInfo['StockCode'] == stock_code:
    
                        #1차수가 매수되지 않은 상태인지를 체크해서 1차수를 일단 매수한다!!
                        for MagicData in MagicDataInfo['MagicDataList']:
                            if MagicData['Number'] == 1: #1차수를 찾아서!          
                                if MagicData['IsBuy'] == False and MagicDataInfo['IsReady'] == True: #매수하지 않은 상태라면 매수를 진행한다!                            
                                 
                                    #새로 시작하는 거니깐 누적 실현손익 0으로 초기화!
                                    MagicDataInfo['RealizedPNL'] = 0
                                
                                    #1차수를 봇이 매수 안했는데 잔고에 수량이 있다면?
                                    if stock_amt > 0:                 
                                        MagicData['IsBuy'] = True
                                        MagicData['EntryPrice'] = stock_avg_price #현재가로 진입했다고 가정합니다!
                                        MagicData['EntryAmt'] = stock_amt
                                        
                                        MagicDataInfo['IsReady'] = False

                                        msg = stock_code + " 스마트스플릿 1차 투자를 하려고 했는데 잔고가 있어서 이를 1차투자로 가정하게 세팅했습니다!"
                                        print(msg) 
                                        line_alert.SendMessage(msg)
                                        
                                    else:                        
                                        #1차수에 해당하는 정보 데이터를 읽는다.
                                        PickSplitMeta = GetSplitMetaInfo(InvestInfo['split_info_list'],1)
                                        
                                        #투자금을 현재가로 나눠서 매수 가능한 수량을 정한다.
                                        BuyAmt = int(PickSplitMeta['invest_money'] / CurrentPrice)
                                        
                                        #1주보다 적다면 투자금이나 투자비중이 작은 상황인데 일단 1주는 매수하게끔 처리 하자!
                                        if BuyAmt < 1:
                                            BuyAmt = 1
                                            
                                        # pprint.pprint(KisUS.MakeBuyLimitOrder(stock_code,BuyAmt,CurrentPrice*1.01))
                                        print("매수처리 : ", BuyAmt)
                                                                            
                                        MagicData['IsBuy'] = True
                                        MagicData['EntryPrice'] = CurrentPrice #현재가로 진입했다고 가정합니다!
                                        MagicData['EntryAmt'] = BuyAmt
                                                                          
                                        MagicDataInfo['IsReady'] = False

                                        msg = stock_code + " 스마트스플릿 1차 투자 완료!"
                                        print(msg) 
                                        line_alert.SendMessage(msg)                           
                        
                                        #매매가 일어났으니 보유수량등을 리프레시 한다!
                                        AccStockList = KisUS.GetMyStockList()
                                        #매수된 상태라면 정보를 넣어준다!!!
                                        for my_stock in AccStockList:
                                            if my_stock['StockCode'] == stock_code:
                                                stock_amt = int(my_stock['StockAmt'])
                                                stock_avg_price = float(my_stock['StockAvgPrice'])
                                                stock_eval_totalmoney = float(my_stock['StockNowMoney'])
                                                stock_revenue_rate = float(my_stock['StockRevenueRate'])
                                                stock_revenue_money = float(my_stock['StockRevenueMoney'])
                                                break
                                    #파일에 저장
                                    with open(bot_file_path, 'w') as outfile:
                                        json.dump(File_MND_List, outfile)   
                                    
                            else:
                                if stock_amt == 0: #잔고가 0이라면 차수 매매는 없는거니깐 초기화!
                                    MagicData['IsBuy'] = False
                                    MagicData['EntryAmt'] = 0
                                    MagicData['EntryPrice'] = 0   

                                    #파일에 저장
                                    with open(bot_file_path, 'w') as outfile:
                                        json.dump(File_MND_List, outfile)     
                        
                        # 매수 안된 차수도 체크해서 매수한다.
                        for MagicData in MagicDataInfo['MagicDataList']:
                            #매수아직 안한 차수!
                            if MagicData['IsBuy'] == False:  
                                if MagicData['Number'] > 1:
                                    #해당 차수의 정보를 읽어온다.
                                    PickSplitMeta = GetSplitMetaInfo(InvestInfo['split_info_list'], MagicData['Number'])
                                        
                                    #투자금을 현재가로 나눠서 매수 가능한 수량을 정한다.
                                    BuyAmt = int(PickSplitMeta['invest_money'] / CurrentPrice)
                                    
                                    #1주보다 적다면 투자금이나 투자비중이 작은 상황인데 일단 1주는 매수하게끔 처리 하자!
                                    if BuyAmt < 1:
                                        BuyAmt = 1
                                    
                                    #매수주문 들어감!
                                    # pprint.pprint(KisUS.MakeBuyLimitOrder(stock_code,BuyAmt,CurrentPrice*1.01))
                                    print("매수처리 : ", BuyAmt)
                                                                        
                                    MagicData['IsBuy'] = True
                                    MagicData['EntryPrice'] = CurrentPrice #현재가로 진입했다고 가정합니다!
                                    MagicData['EntryAmt'] = BuyAmt
                                                                        
                                    MagicDataInfo['IsReady'] = False
                                    
                                    #파일에 저장
                                    with open(bot_file_path, 'w') as outfile:
                                        json.dump(File_MND_List, outfile)

                                    msg = stock_code + " 스마트스플릿 "+str(MagicData['Number'])+"차 매수 완료!" 
                                    print(msg) 
                                    line_alert.SendMessage(msg)           
                    
                                    #매매가 일어났으니 보유수량등을 리프레시 한다!
                                    AccStockList = KisUS.GetMyStockList()
                                    #매수된 상태라면 정보를 넣어준다!!!
                                    for my_stock in AccStockList:
                                        if my_stock['StockCode'] == stock_code:
                                            stock_amt = int(my_stock['StockAmt'])
                                            stock_avg_price = float(my_stock['StockAvgPrice'])
                                            stock_eval_totalmoney = float(my_stock['StockNowMoney'])
                                            stock_revenue_rate = float(my_stock['StockRevenueRate'])
                                            stock_revenue_money = float(my_stock['StockRevenueMoney'])
                                            break
                                        
                print("MACD GC 발생! 매수 진행")
            else:
                print("매수 신호 미발생")    

                
'''               
                
                
                
                
        
        
        
        
        
        
        for MagicDataInfo in File_MND_List:          
            if MagicDataInfo['StockCode'] == stock_code:
                df = Common.GetOhlcv("KR",stock_code, 200)  ### 일봉정보를 가져온다 200개!
                
                prevOpen = df['open'].iloc[-2] #전일 시가
                prevClose = df['close'].iloc[-2] #전일 종가
                
                Ma5_Before = Common.GetMA(df,5,-3) #전전일 기준
                Ma5 = Common.GetMA(df,5,-2) #전일 기준
                
                CurrentPrice = KisUS.GetCurrentPrice(stock_code)

                #1차수가 매수되지 않은 상태인지를 체크해서 1차수를 일단 매수한다!!
                for MagicData in MagicDataInfo['MagicDataList']:
                    if MagicData['Number'] == 1: #1차수를 찾아서!          
                        if MagicData['IsBuy'] == False and MagicDataInfo['IsReady'] == True: #매수하지 않은 상태라면 매수를 진행한다!                            
                            #MA small<big and 120 이평성 아래      
                            if stock_data[str(small_ma)+'ma_before'].values[0] < stock_data[str(big_ma)+'ma_before'].values[0] and CurrentPrice < stock_data['120ma_before'].values[0]: 
                                if (macd_before['macd_siginal'] <= macd_before['macd']) and (macd['macd_siginal'] > macd['macd']): # MACD golden cross 
                  
                                    #새로 시작하는 거니깐 누적 실현손익 0으로 초기화!
                                    MagicDataInfo['RealizedPNL'] = 0
                                
                                    #1차수를 봇이 매수 안했는데 잔고에 수량이 있다면?
                                    if stock_amt > 0:                 
                                        MagicData['IsBuy'] = True
                                        MagicData['EntryPrice'] = stock_avg_price #현재가로 진입했다고 가정합니다!
                                        MagicData['EntryAmt'] = stock_amt

                                        msg = stock_code + " 스마트스플릿 1차 투자를 하려고 했는데 잔고가 있어서 이를 1차투자로 가정하게 세팅했습니다!"
                                        print(msg) 
                                        line_alert.SendMessage(msg)
                                        
                                    else:                        
                                        #1차수에 해당하는 정보 데이터를 읽는다.
                                        PickSplitMeta = GetSplitMetaInfo(InvestInfo['split_info_list'],1)
                                        
                                        #투자금을 현재가로 나눠서 매수 가능한 수량을 정한다.
                                        BuyAmt = int(PickSplitMeta['invest_money'] / CurrentPrice)
                                        
                                        #1주보다 적다면 투자금이나 투자비중이 작은 상황인데 일단 1주는 매수하게끔 처리 하자!
                                        if BuyAmt < 1:
                                            BuyAmt = 1
                                            
                                        pprint.pprint(KisUS.MakeBuyLimitOrder(stock_code,BuyAmt,CurrentPrice*1.01))
                                                                            
                                        MagicData['IsBuy'] = True
                                        MagicData['EntryPrice'] = CurrentPrice #현재가로 진입했다고 가정합니다!
                                        MagicData['EntryAmt'] = BuyAmt
                                    
                                        MagicDataInfo['IsReady'] = False

                                        msg = stock_code + " 스마트스플릿 1차 투자 완료!"
                                        print(msg) 
                                        line_alert.SendMessage(msg)                           
                        
                                        #매매가 일어났으니 보유수량등을 리프레시 한다!
                                        AccStockList = KisUS.GetMyStockList()
                                        #매수된 상태라면 정보를 넣어준다!!!
                                        for my_stock in AccStockList:
                                            if my_stock['StockCode'] == stock_code:
                                                stock_amt = int(my_stock['StockAmt'])
                                                stock_avg_price = float(my_stock['StockAvgPrice'])
                                                stock_eval_totalmoney = float(my_stock['StockNowMoney'])
                                                stock_revenue_rate = float(my_stock['StockRevenueRate'])
                                                stock_revenue_money = float(my_stock['StockRevenueMoney'])
                                                break
                                    #파일에 저장
                                    with open(bot_file_path, 'w') as outfile:
                                        json.dump(File_MND_List, outfile)   
                            
                    else:
                        if stock_amt == 0: #잔고가 0이라면 차수 매매는 없는거니깐 초기화!
                            MagicData['IsBuy'] = False
                            MagicData['EntryAmt'] = 0
                            MagicData['EntryPrice'] = 0   

                            #파일에 저장
                            with open(bot_file_path, 'w') as outfile:
                                json.dump(File_MND_List, outfile)     
                 
                #매수된 차수가 있다면 수익률을 체크해서 매도하고, 매수 안된 차수도 체크해서 매수한다.
                for MagicData in MagicDataInfo['MagicDataList']:
                
                    #해당 차수의 정보를 읽어온다.
                    PickSplitMeta = GetSplitMetaInfo(InvestInfo['split_info_list'],MagicData['Number'])
                    # {"number":XX, "target_rate":XX, "trigger_rate":XX, "invest_money":XX}   
                    
                    #매수된 차수이다.
                    if MagicData['IsBuy'] == True:  
                        #현재 수익률을 구한다!
                        CurrentRate = (CurrentPrice - MagicData['EntryPrice']) / MagicData['EntryPrice'] * 100.0
                        print(stock_code, ") ",  MagicData['Number'], "차 수익률 ", round(CurrentRate,2) , "% 목표수익률", PickSplitMeta['target_rate'], "%")
                   
                        #현재 수익률이 목표 수익률보다 높다면
                        if CurrentRate >= PickSplitMeta['target_rate'] and stock_amt > 0 and (stock_revenue_money + MagicDataInfo['RealizedPNL']) > 0 :    
                            SellAmt = MagicData['EntryAmt']
                            
                            IsOver = False
                            #만약 매도할 수량이 수동 매도등에 의해서 보유 수량보다 크다면 보유수량으로 정정해준다!
                            if SellAmt > stock_amt:
                                SellAmt = stock_amt
                                IsOver = True

                            pprint.pprint(KisUS.MakeSellLimitOrder(stock_code,SellAmt,CurrentPrice*0.99))

                            MagicData['IsBuy'] = False
                            MagicDataInfo['RealizedPNL'] += (stock_revenue_money * SellAmt/stock_amt)

                            msg = stock_code + " 스마트스플릿 "+str(MagicData['Number'])+"차 수익 매도 완료! 차수 목표수익률" + str(PickSplitMeta['target_rate']) +"% 만족" 
                            
                            if IsOver == True:
                                msg = stock_code + " 스마트스플릿 "+str(MagicData['Number'])+"차 수익 매도 완료! 차수 목표수익률" + str(PickSplitMeta['target_rate']) +"% 만족 매도할 수량이 보유 수량보다 많은 상태라 모두 매도함!" 
                                
                            print(msg) 
                            line_alert.SendMessage(msg)

                            #1차수 매도라면 레디값을 False로 바꿔서 오늘 1차 매수가 없도록 한다!
                            if MagicData['Number'] == 1:
                               MagicDataInfo['IsReady'] = False

                            #파일에 저장
                            with open(bot_file_path, 'w') as outfile:
                                json.dump(File_MND_List, outfile)
                                
                            #매매가 일어났으니 보유수량등을 리프레시 한다!
                            AccStockList = KisUS.GetMyStockList()
                            #매수된 상태라면 정보를 넣어준다!!!
                            for my_stock in AccStockList:
                                if my_stock['StockCode'] == stock_code:
                                    stock_amt = int(my_stock['StockAmt'])
                                    stock_avg_price = float(my_stock['StockAvgPrice'])
                                    stock_eval_totalmoney = float(my_stock['StockNowMoney'])
                                    stock_revenue_rate = float(my_stock['StockRevenueRate'])
                                    stock_revenue_money = float(my_stock['StockRevenueMoney'])
                                    break             
                        
                    #매수아직 안한 차수!
                    else:
                        if MagicData['Number'] > 1:
                            #이전차수 정보를 읽어온다.
                            PrevMagicData = GetSplitDataInfo(MagicDataInfo['MagicDataList'],MagicData['Number'] - 1)
                  
                            if PrevMagicData['IsBuy'] == True:
                                #이전 차수 수익률을 구한다!
                                prevRate = (CurrentPrice - PrevMagicData['EntryPrice']) / PrevMagicData['EntryPrice'] * 100.0
                                print(stock_code, ") ", MagicData['Number'], "차 진입을 위한 ",MagicData['Number']-1,"차 수익률 ", round(prevRate,2) , "% 트리거 수익률", PickSplitMeta['trigger_rate'], "%")

                                #AdditionlCondition = True
                                #if MagicData['Number'] % 2 == 1: #홀수 차수일 경우
                                #    if prevOpen < prevClose and (prevClose >= Ma5 or Ma5_Before <= Ma5):
                                #        AdditionlCondition = True
                                #    else:
                                #        AdditionlCondition = False
                                #else: #짝수 차수일 경우
                                #    AdditionlCondition = True

                                #현재 손실률이 트리거 손실률보다 낮다면
                                if prevRate <= PickSplitMeta['trigger_rate']:                                # and AdditionlCondition == True:
                      
                                    #투자금을 현재가로 나눠서 매수 가능한 수량을 정한다.
                                    BuyAmt = int(PickSplitMeta['invest_money'] / CurrentPrice)
                                    
                                    #1주보다 적다면 투자금이나 투자비중이 작은 상황인데 일단 1주는 매수하게끔 처리 하자!
                                    if BuyAmt < 1:
                                        BuyAmt = 1

                                    #매수주문 들어감!
                                    pprint.pprint(KisUS.MakeBuyLimitOrder(stock_code,BuyAmt,CurrentPrice*1.01))
                                    
                                    MagicData['IsBuy'] = True
                                    MagicData['EntryPrice'] = CurrentPrice #현재가로 진입했다고 가정합니다!
                                    MagicData['EntryAmt'] = BuyAmt
                                    
                                    MagicDataInfo['IsReady'] = False

                                    #파일에 저장
                                    with open(bot_file_path, 'w') as outfile:
                                        json.dump(File_MND_List, outfile)
                                        
                                    msg = stock_code + " 스마트스플릿 "+str(MagicData['Number'])+"차 매수 완료! 이전 차수 손실률" + str(PickSplitMeta['trigger_rate']) +"% 만족" 
                                    print(msg) 
                                    line_alert.SendMessage(msg)
                                    
                                    #매매가 일어났으니 보유수량등을 리프레시 한다!
                                    AccStockList = KisUS.GetMyStockList()
                                    #매수된 상태라면 정보를 넣어준다!!!
                                    for my_stock in AccStockList:
                                        if my_stock['StockCode'] == stock_code:
                                            stock_amt = int(my_stock['StockAmt'])
                                            stock_avg_price = float(my_stock['StockAvgPrice'])
                                            stock_eval_totalmoney = float(my_stock['StockNowMoney'])
                                            stock_revenue_rate = float(my_stock['StockRevenueRate'])
                                            stock_revenue_money = float(my_stock['StockRevenueMoney'])
                                            break

                
                IsFullBuy = True #풀매수 상태!
                
                for MagicData in MagicDataInfo['MagicDataList']:
                    #한 차수라도 매수되지 않은 차수가 있다면 풀 매수 상태는 아니다!!!
                    if MagicData['IsBuy'] == False:
                        IsFullBuy = False
                        break
                        
                #풀매수 상태라면
                if IsFullBuy == True:
                    #마지막 차수 정보를 얻어온다.
                    LastSplitMeta = GetSplitMetaInfo(InvestInfo['split_info_list'],int(DivNum))
                    #'split_info_list' : [{"number":1, "target_rate":XX, "trigger_rate":XX, "invest_money":XX}, ...]
                    #차수, 목표수익률, 매수기준 손실률 ,투자금액

                    LastMagicData = GetSplitDataInfo(MagicDataInfo['MagicDataList'],int(DivNum))
                    # File_MND_List → 인출 MagicDataInfo  # "MagicDataList" : [{"Number": 1, "EntryPrice": 12215, "EntryAmt": 37, "IsBuy": True}, ...] 
                
                    #마지막 차수의 손익률
                    LastRate = (CurrentPrice - LastMagicData['EntryPrice']) / LastMagicData['EntryPrice'] * 100.0
                    
                    #그런데 마지막 차수 마저 갭 간격 비율 만큼 추가 하락을 했다!!!
                    if LastRate <= LastSplitMeta['trigger_rate']:
                
                        msg = stock_code + " 스마트스플릿 풀매수 상태인데 더 하락하여 2차수 손절 및 초기화!" 
                        print(msg) 
                        line_alert.SendMessage(msg)
                        
                        SecondMagicData = GetSplitDataInfo(MagicDataInfo['MagicDataList'],2)
                        SellAmt = SecondMagicData['EntryAmt']
                        
                        IsOver = False
                        #만약 매도할 수량이 수동 매도등에 의해서 보유 수량보다 크다면 보유수량으로 정정해준다!
                        if SellAmt > stock_amt:
                            SellAmt = stock_amt
                            IsOver = True
                    
                        pprint.pprint(KisUS.MakeSellLimitOrder(stock_code,SellAmt,CurrentPrice*0.99))
                        
                        SecondMagicData['IsBuy'] = False
                        MagicDataInfo['RealizedPNL'] += (stock_revenue_money * SellAmt/stock_amt)
                        
                        msg = stock_code + " 스마트스플릿 풀매수 상태여서 2차 수량 손절 완료! " + str(SellAmt) + "주 매도!"
                        
                        if IsOver == True:
                            msg = stock_code + " 스마트스플릿 풀매수 상태인데 1차수 매도할 수량이 보유 수량보다 많은 상태라 모두 매도함!" + str(SellAmt) + "주 매도!"
                            
                        print(msg) 
                        line_alert.SendMessage(msg)
                    
                        for i in range(int(DivNum)):
                            Number = i + 1
                            
                            if Number >= 2: 
                                data = MagicDataInfo['MagicDataList'][i]
                                if Number == int(DivNum):
                                    data['IsBuy'] = False
                                    data['EntryAmt'] = 0
                                    data['EntryPrice'] = 0
                                    
                                    msg = stock_code + " 스마트스플릿 " + str(Number) + "차수 비워둠!\n 10차수를 새로 매수할 수 있음!" 
                                    print(msg) 
                                    line_alert.SendMessage(msg)
                        
                                else:
                                    data['IsBuy'] = MagicDataInfo['MagicDataList'][i + 1]['IsBuy']
                                    data['EntryAmt'] = MagicDataInfo['MagicDataList'][i + 1]['EntryAmt']
                                    data['EntryPrice'] = MagicDataInfo['MagicDataList'][i + 1]['EntryPrice']
                                    
                                    msg = stock_code + " 스마트스플릿 " + str(Number + 1) + "차수 데이터를 " +  str(Number) + "차수로 옮김!"
                                    print(msg) 
                                    line_alert.SendMessage(msg)


                        #파일에 저장
                        with open(bot_file_path, 'w') as outfile:
                            json.dump(File_MND_List, outfile)
                     
                
else:
    #장이 끝나고 1차수 매매 가능하게 True로 변경
    for StockInfo in File_MND_List:
        StockInfo['IsReady'] = True


    #파일에 저장
    with open(bot_file_path, 'w') as outfile:
        json.dump(File_MND_List, outfile)

for MagicDataInfo in File_MND_List:
    print(MagicDataInfo['StockName'],"(",MagicDataInfo['StockCode'] ,") 누적 실현 손익:", MagicDataInfo['RealizedPNL'])
    
#pprint.pprint(File_MND_List)


####################################################
# if stock_data[str(small_ma)+'ma_before'].values[0] > stock_data[str(big_ma)+'ma_before'].values[0]:
    #     print("보유!! (추가 매수금지) - 적정 (일부) 매도시점 검토 중")
    # else:
    #     print("일부 매도 후 매수 시점 모니터링")
    #     if NowClosePrice < stock_data['20ma_before'].values[0]:
    #         print("20일선 하향 돌파, 매수 optional!")
    #     if NowClosePrice < stock_data['60ma_before'].values[0]:
    #         print("20% 5회 분할 매수")
    #     if NowClosePrice < stock_data['120ma_before'].values[0]:
    #         print("30% 5회 분할 매수")
    #     # if NowClosePrice < RSI_30
    #     #     print("30% 5회 분할 매수")
        
    #     # MACD 매수 시점 점검
    #     if macd['macd_siginal'] < 0:
    #         print("MACD negative!")
    #         if (macd_before['macd_siginal'] <= macd_before['macd']) and (macd['macd_siginal'] > macd['macd']): # MACD golden cross 
    #             print("MACD Golden Cross!! 50% 5회 분할 매수")
    #         else:
    #             print("MACD signal is still under baseline!")
    #     else: 
    #         print("MACD positive!")

 
######################################################
                                    
#이동평균선 수치를 구해준다 첫번째: 일봉 정보, 두번째: 기간, 세번째: 기준 날짜
def GetMA(ohlcv,period,st):
    close = ohlcv["close"]
    ma = close.rolling(period).mean()
    return float(ma.iloc[st])


#RSI지표 수치를 구해준다. 첫번째: 분봉/일봉 정보, 두번째: 기간, 세번째: 기준 날짜
def GetRSI(ohlcv,period,st):
    delta = ohlcv["close"].diff()
    up, down = delta.copy(), delta.copy()
    up[up < 0] = 0
    down[down > 0] = 0
    _gain = up.ewm(com=(period - 1), min_periods=period).mean()
    _loss = down.abs().ewm(com=(period - 1), min_periods=period).mean()
    RS = _gain / _loss
    return float(pd.Series(100 - (100 / (1 + RS)), name="RSI").iloc[st])

#MACD의 12,26,9 각 데이타를 리턴한다 첫번째: 분봉/일봉 정보, 두번째: 기준 날짜
def GetMACD(ohlcv,st):
    macd_short, macd_long, macd_siginal=12,26,9

    ohlcv["MACD_short"]=ohlcv["close"].ewm(span=macd_short).mean()
    ohlcv["MACD_long"]=ohlcv["close"].ewm(span=macd_long).mean()
    ohlcv["MACD"]=ohlcv["MACD_short"] - ohlcv["MACD_long"]
    ohlcv["macd_siginal"]=ohlcv["MACD"].ewm(span=macd_siginal).mean() 

    dic_macd = dict()
    
    dic_macd['macd'] = ohlcv["MACD"].iloc[st]
    dic_macd['macd_siginal'] = ohlcv["macd_siginal"].iloc[st]
    dic_macd['ocl'] = dic_macd['macd'] - dic_macd['macd_siginal']

    return dic_macd



#스토캐스틱 %K %D 값을 구해준다 첫번째: 분봉/일봉 정보, 두번째: 기간, 세번째: 기준 날짜
def GetStoch(ohlcv,period,st):

    dic_stoch = dict()

    ndays_high = ohlcv['high'].rolling(window=period, min_periods=1).max()
    ndays_low = ohlcv['low'].rolling(window=period, min_periods=1).min()
    fast_k = (ohlcv['close'] - ndays_low)/(ndays_high - ndays_low)*100
    slow_d = fast_k.rolling(window=3, min_periods=1).mean()

    dic_stoch['fast_k'] = fast_k.iloc[st]
    dic_stoch['slow_d'] = slow_d.iloc[st]

    return dic_stoch

'''   