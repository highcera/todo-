#-*-coding:utf-8 -*-
'''

관련 포스팅

레버리지 ETF 위 아래 변동성 돌파 전략!
https://blog.naver.com/zacra/223128702427

위 포스팅을 꼭 참고하세요!!!

하다가 잘 안되시면 계속 내용이 추가되고 있는 아래 FAQ를 꼭꼭 체크하시고

주식/코인 자동매매 FAQ
https://blog.naver.com/zacra/223203988739

그래도 안 된다면 구글링 해보시고
그래도 모르겠다면 클래스 댓글, 블로그 댓글, 단톡방( https://blog.naver.com/zacra/223111402375 )에 질문주세요! ^^

 

'''

import KIS_Common as Common
import KIS_API_Helper_KR as KisKR
import time
import pprint
import pandas as pd
import json
from datetime import datetime

import line_alert



#계좌 선택.. "VIRTUAL" 는 모의 계좌!
Common.SetChangeMode("VIRTUAL") #REAL or VIRTUAL


BOT_NAME = Common.GetNowDist() + "_MyLeverageTop_Bot"





#포트폴리오 이름
PortfolioName = "게만아 레버리지 ETF 매매 전략!"


#시간 정보를 읽는다
time_info = time.gmtime()

day_str = str(time_info.tm_mon) + "-" + str(time_info.tm_mday)

print(day_str)


            

#####################################################################################################################################

#계좌 잔고를 가지고 온다!
Balance = KisKR.GetBalance()
#####################################################################################################################################

'''-------통합 증거금 사용자는 아래 코드도 사용할 수 있습니다! -----------'''
#통합증거금 계좌 사용자 분들중 만약 미국계좌랑 통합해서 총자산을 계산 하고 포트폴리오 비중에도 반영하고 싶으시다면 아래 코드를 사용하시면 되고 나머지는 동일합니다!!!
#Balance = Common.GetBalanceKrwTotal()

'''-----------------------------------------------------------'''
#####################################################################################################################################


print("--------------내 보유 잔고---------------------")

pprint.pprint(Balance)

print("--------------------------------------------")


##########################################################

print("--------------내 보유 주식---------------------")
#그리고 현재 이 계좌에서 보유한 주식 리스트를 가지고 옵니다!
MyStockList = KisKR.GetMyStockList()
pprint.pprint(MyStockList)
print("--------------------------------------------")
##########################################################


#실제 투자 종목!!!
InvestStockList = ["306950","412570","243880","243890","225040","225050","225060","196030", "236350","204480","371130"]





###################################################################
###################################################################
LeverageStragegyList = list()
#파일 경로입니다.
data_file_path = "/var/autobot/KrStock_" + BOT_NAME + ".json"

try:
    #이 부분이 파일을 읽어서 리스트에 넣어주는 로직입니다. 
    with open(data_file_path, 'r') as json_file:
        LeverageStragegyList = json.load(json_file)

except Exception as e:
    print("Init....")

    for stock_code in InvestStockList:

        LeverageStragegyData = dict()
        LeverageStragegyData['StockCode'] = stock_code #대상 종목 코드
        LeverageStragegyData['StockName'] = KisKR.GetStockName(stock_code) #종목 이름
        LeverageStragegyData['Status'] = "REST" #상태 READY(돌파를체크해야하는 준비상태), INVESTING(돌파해서 투자중), INVESTING_TRY(매수 주문 들어감) REST(조건불만족,투자안함,돌파체크안함) 
        LeverageStragegyData['DayStatus'] = "NONE" #오늘 매수(BUY)하는 날인지 매도(SELL)하는 날인지 대상이 아닌지 (NONE) 체크
        LeverageStragegyData['TargetPrice'] = 0 #돌파가격

        LeverageStragegyList.append(LeverageStragegyData)

    #파일에 저장
    with open(data_file_path, 'w') as outfile:
        json.dump(LeverageStragegyList, outfile)


###################################################################
###################################################################
DateData = dict()
#파일 경로입니다.
date_file_path = "/var/autobot/KrStock_" + BOT_NAME + "_Date.json"

try:
    #이 부분이 파일을 읽어서 리스트에 넣어주는 로직입니다. 
    with open(date_file_path, 'r') as json_file:
        DateData = json.load(json_file)

except Exception as e:
    print("Init....")

    DateData['Date'] = "00" #오늘날짜

    #파일에 저장
    with open(date_file_path, 'w') as outfile:
        json.dump(DateData, outfile)

###################################################################
###################################################################





###################################################################
###################################################################
#리스트에서 데이터를 리턴!
def GetLeverageStragegyData(stock_code,LeverageStragegyList):
    ResultData = None
    for LeverageStragegyData in LeverageStragegyList:
        if LeverageStragegyData['StockCode'] == stock_code:
            ResultData = LeverageStragegyData
            break
    return ResultData




#내 계좌의 총 평가금액에서 해당 봇에게 할당할 총 금액비율 1.0 = 100%  0.5 = 50%
InvestRate = 0.2

#기준이 되는 내 총 평가금액에서 투자비중을 곱해서 나온 포트폴리오에 할당된 돈!!
TotalMoney = float(Balance['TotalMoney']) * InvestRate

print("전략에 투자하는 총 금액: ", format(round(TotalMoney), ','))

InvestMoney = TotalMoney


DivNum = int(len(InvestStockList)/2) #투자종목 개수 나누기 2
InvestMoneyCell = InvestMoney / (DivNum + 1) #거기에 1을 더하고 나눠서 종목당 매매금을 정한다

print("종목당 투자하는 총 금액: ", format(round(InvestMoneyCell), ','))


#마켓이 열렸는지 여부~!
IsMarketOpen = KisKR.IsMarketOpen()

IsLP_OK = True
#정각 9시 5분 전에는 LP유동성 공급자가 없으니 매매를 피하고자.
if time_info.tm_hour == 0: #9시인데
    if time_info.tm_min < 5: #5분보다 적은 값이면
        IsLP_OK = False
        

if IsMarketOpen == True and IsLP_OK == True: 

    #혹시 이 봇을 장 시작하자 마자 돌린다면 20초르 쉬어준다.
    #그 이유는 20초는 지나야 오늘의 일봉 정보를 제대로 가져오는데
    #tm_hour가 0은 9시, 1은 10시를 뜻한다. 수능 등 10시에 장 시작하는 경우르 대비!
    if time_info.tm_hour in [0,1] and time_info.tm_min == 0:
        time.sleep(20.0)
        

    print("Market Is Open!!!!!!!!!!!")


    #날짜가 다르다면 날이 바뀐거다 매매할 섹터를 찾고 처리하자!
    if day_str != DateData['Date']:
            
            
        line_alert.SendMessage(PortfolioName + "  장이 열려서 매매 가능!!")

        #데이터를 조합한다.
        stock_df_list = []

        for stock_code in InvestStockList:
            df = Common.GetOhlcv("KR", stock_code,30)

            period = 14

            delta = df["close"].diff()
            up, down = delta.copy(), delta.copy()
            up[up < 0] = 0
            down[down > 0] = 0
            _gain = up.ewm(com=(period - 1), min_periods=period).mean()
            _loss = down.abs().ewm(com=(period - 1), min_periods=period).mean()
            RS = _gain / _loss

            df['RSI'] = pd.Series(100 - (100 / (1 + RS)), name="RSI")
            df['prevRSI'] = df['RSI'].shift(1)
            df['prevRSI2'] = df['RSI'].shift(2)

            df['prevHigh'] = df['high'].shift(1)
            df['prevLow'] = df['low'].shift(1)
            df['prevOpen'] = df['open'].shift(1)
            df['value_ma'] = df['value'].rolling(window=10).max().shift(1)

            df.dropna(inplace=True) #데이터 없는건 날린다!


            data_dict = {stock_code: df}
            stock_df_list.append(data_dict)
            print("---stock_code---", stock_code , " len ",len(df))
            pprint.pprint(df)



        # Combine the OHLCV data into a single DataFrame
        combined_df = pd.concat([list(data_dict.values())[0].assign(stock_code=stock_code) for data_dict in stock_df_list for stock_code in data_dict])

        # Sort the combined DataFrame by date
        combined_df.sort_index(inplace=True)

        pprint.pprint(combined_df)
        print(" len(combined_df) ", len(combined_df))

        date = combined_df.iloc[-1].name


        # 일봉 정보 가지고 오는 모듈이 달라지면 에러가 나므로 예외처리
        date_format = "%Y-%m-%d %H:%M:%S"
        date_object = None

        try:
            date_object = datetime.strptime(str(date), date_format)
        
        except Exception as e:
            try:
                date_format = "%Y%m%d"
                date_object = datetime.strptime(str(date), date_format)

            except Exception as e2:
                date_format = "%Y-%m-%d"
                date_object = datetime.strptime(str(date), date_format)
                

        # 요일 가져오기 (0: 월요일, 1: 화요일,2 수요일 3 목요일 4 금요일 5 토요일 ..., 6: 일요일)
        weekday = date_object.weekday()
        print("--weekday--", weekday, time_info.tm_wday)

        #가장 최근 데이터의 날짜의 요일과 봇이 실행되는 요일은 같아야 한다.
        #이게 다르다면 아직 최근 데이터의 날자가 갱신 안되었단 이야기인데 이는 9시 정각이나..(20초 딜레이가 필요) 수능등으로 장 오픈시간이 지연되었을때 다를 수 있다. 그때는 매매하면 안된다
        if weekday == time_info.tm_wday:


            DateData['Date'] = day_str #오늘 맨처음 할일 (종목 선정 및 돌파가격 설정, 상태 설정)을 끝냈으니 날짜를 넣어 다음날 다시 실행되게 한다.
            with open(date_file_path, 'w') as outfile:
                json.dump(DateData, outfile)

            #기본적으로 날이 바뀌었기 때문에 데이 조건(BUY_DAY,SELL_DAY)를 모두 초기화 한다!
            for LeverageStragegyData in LeverageStragegyList:
                LeverageStragegyData['DayStatus'] = "NONE"

                #그리고 투자중 상태는 SELL_DAY로 바꿔준다!!
                if LeverageStragegyData['Status'] == "INVESTING":
                    LeverageStragegyData['DayStatus'] = "SELL_DAY"

                    msg = LeverageStragegyData['StockName'] + "  투자중 상태에요! 컷라인 하향돌파하면 매도로 트레이딩 종료 합니다.!!"
                    print(msg)
                    line_alert.SendMessage(msg)


            #투자 종목중 어제 RSI가 큰 종목 상위 50%를 구한다. 이게 오늘의 매매 대상!
            pick_stocks = combined_df.loc[combined_df.index == date].groupby('stock_code')['prevRSI'].max().nlargest(DivNum)


            #1개이기 때문에 for문을 돌 필요는 없지만 확장을 위해.
            for stock_code in pick_stocks.index:
                stock_data = combined_df[(combined_df.index == date) & (combined_df['stock_code'] == stock_code)]

                #해당 정보를 읽는다.
                LeverageStragegyData = GetLeverageStragegyData(stock_code,LeverageStragegyList)

                #만약 정보가 없다면 새로 추가된 종목이니 새로 저장한다!!!
                if LeverageStragegyData == None:

                    LeverageStragegyData = dict()
                    LeverageStragegyData['StockCode'] = stock_code #대상 종목 코드
                    LeverageStragegyData['StockName'] = KisKR.GetStockName(stock_code) #종목 이름
                    LeverageStragegyData['Status'] = "REST" #상태 READY(돌파를체크해야하는 준비상태), INVESTING(돌파해서 투자중), REST(조건불만족,투자안함,돌파체크안함) 
                    LeverageStragegyData['DayStatus'] = "NONE" #오늘 매수하는 날인지 매도하는 날인지 체크
                    LeverageStragegyData['TargetPrice'] = 0 #돌파가격

                    LeverageStragegyList.append(LeverageStragegyData)

    
                DolPaPrice = stock_data['open'].values[0] + ((stock_data['prevHigh'].values[0] - stock_data['prevLow'].values[0]) * 0.3)


                #어제 무슨 이유에서건 매수 실패했다면 일단 REST로!
                if LeverageStragegyData['Status'] == "INVESTING_TRY":
                    LeverageStragegyData['Status'] = "REST"
                    LeverageStragegyData['DayStatus'] = "NONE"

                
                if LeverageStragegyData['Status'] != "INVESTING": #투자 상태가 아니라면 오늘 돌파를 체크하여 매수시도할 수 있다!
                    
                    IsBuyReady = True #일단 무조건 True 만약 필터하고자 하면 False로 하고 조건만족시 True로 바꾸면 된다.
                    

                    LeverageStragegyData['StockCode'] = stock_code #대상 종목 코드
                    LeverageStragegyData['StockName'] = KisKR.GetStockName(stock_code)


                    #기본 필터 통과!! 돌파가격을 정하고 READY상태로 변경
                    if IsBuyReady == True:
                        print("IS Ready!!!")
                        LeverageStragegyData['TargetPrice'] = DolPaPrice #돌파가격

                        LeverageStragegyData['Status'] = "READY"
                        LeverageStragegyData['DayStatus'] = "BUY_DAY"


                        msg = LeverageStragegyData['StockName'] + " 돌파하면 매수합니다!!!"
                        print(msg)
                        line_alert.SendMessage(msg)

                    #기본 필터 통과 실패 매수 안함! - 이 전략에서는 해당사항 없음.
                    else:
                        print("No Ready")
        
                        LeverageStragegyData['Status'] = "REST"
                        LeverageStragegyData['DayStatus'] = "NONE"


                        msg = LeverageStragegyData['StockName'] + "  조건을 불만족하여 오늘 돌파매수는 쉽니다!!!"
                        print(msg)
                        line_alert.SendMessage(msg)





                #파일에 저장
                with open(data_file_path, 'w') as outfile:
                    json.dump(LeverageStragegyList, outfile)
        else:

            if time_info.tm_min == 0 or time_info.tm_min == 30:
                msg = "요일이 다르게 나왔어요! 좀 더 기다려봐요!"
                print(msg)
                line_alert.SendMessage(msg)
                

    if day_str == DateData['Date']: #오늘 할일을 한다!


        for LeverageStragegyData in LeverageStragegyList:
            pprint.pprint(LeverageStragegyData)

            #현재가!
            CurrentPrice = KisKR.GetCurrentPrice(LeverageStragegyData['StockCode'])        
            
            if LeverageStragegyData['DayStatus'] == "SELL_DAY":

                #만약 투자중이라면 조건을 체크!
                if LeverageStragegyData['Status'] == "INVESTING": #투자중 상태


                    stock_amt = 0 #수량
                    stock_avg_price = 0 #평단
                    stock_eval_totalmoney = 0 #총평가금액!
                    stock_revenue_rate = 0 #종목 수익률
                    stock_revenue_money = 0 #종목 수익금

                
                    
                    #내가 보유한 주식 리스트에서 매수된 잔고 정보를 가져온다
                    for my_stock in MyStockList:
                        if my_stock['StockCode'] == LeverageStragegyData['StockCode']:
                            stock_name = my_stock['StockName']
                            stock_amt = int(my_stock['StockAmt'])
                            stock_avg_price = float(my_stock['StockAvgPrice'])
                            stock_eval_totalmoney = float(my_stock['StockNowMoney'])
                            stock_revenue_rate = float(my_stock['StockRevenueRate'])
                            stock_revenue_money = float(my_stock['StockRevenueMoney'])

                            break
                        
                    if stock_amt > 0:


                        df = Common.GetOhlcv("KR", LeverageStragegyData['StockCode'],30)

                        CutPrice = df['open'].iloc[-1] - ((df['high'].iloc[-2] - df['low'].iloc[-2]) * 0.2)

                        CurrentPrice = KisKR.GetCurrentPrice(LeverageStragegyData['StockCode'])  

                        if CurrentPrice <= CutPrice:

                            #LP가 활동 중일 때만 시장가 매도 한다!
                            if IsLP_OK == True:

                                pprint.pprint(KisKR.MakeSellMarketOrder(LeverageStragegyData['StockCode'],stock_amt))
                                
                                LeverageStragegyData['Status'] = "REST" 
                                LeverageStragegyData['DayStatus'] = "NONE"

                                msg = LeverageStragegyData['StockName']  + " 모두 시장가 매도!!! " + str(stock_revenue_money) + " 수익 확정!! 수익률:" + str(stock_revenue_rate) + "%"
                                print(msg)
                                line_alert.SendMessage(msg)

                        
                    else:
                        LeverageStragegyData['Status'] = "REST" 
                        LeverageStragegyData['DayStatus'] = "NONE"


                        msg = LeverageStragegyData['StockName']  + " 매수했다고 기록되었는데 물량이 없네요? 암튼 초기화 했어요 다음날 다시 전략 시작합니다!"
                        print(msg)
                        line_alert.SendMessage(msg)



            else:
                if LeverageStragegyData['DayStatus'] == "BUY_DAY":              
                    
                    #매수 시도가 진행 되었다
                    if LeverageStragegyData['Status'] == "INVESTING_TRY":
                        
                        MyStockList = KisKR.GetMyStockList()

                        stock_amt = 0 #수량

                        
                        #내가 보유한 주식 리스트에서 매수된 잔고 정보를 가져온다
                        for my_stock in MyStockList:
                            if my_stock['StockCode'] == LeverageStragegyData['StockCode']:
                                stock_amt = int(my_stock['StockAmt'])
                                break
                            
                        #실제로 1주라도 매수가 되었다면 투자중 상태로 변경!!!
                        if stock_amt > 0:
                            LeverageStragegyData['Status'] = "INVESTING"
                            LeverageStragegyData['DayStatus'] = "NONE"
                            
                            msg = LeverageStragegyData['StockName'] + " 투자중이에요!!"
                            print(msg)
                            line_alert.SendMessage(msg)


                        #아니라면 알림으로 알려준다!!
                        else:
                    
                            msg = LeverageStragegyData['StockName'] + "  조건을 만족하여 매수 시도했는데 아직 1주도 매수되지 않았어요!  "
                            print(msg)
                            line_alert.SendMessage(msg)
                            
                        



                        
                    #상태를 체크해서 READY라면 돌파시 매수한다!
                    if LeverageStragegyData['Status'] == "READY":
                        print("돌파 체크중...")
                    

                        #돌파가격보다 현재가가 높다? 돌파한거다 매수한다!
                        if CurrentPrice >= LeverageStragegyData['TargetPrice']:


                            #매수할 수량을 계산한다! - 5분할 합니다!!
                            BuyAmt = int(InvestMoneyCell / CurrentPrice)


                            #최소 5주는 살 수 있도록!
                            if BuyAmt < 5:
                                BuyAmt = 5


                        

                            SliceAmt = int(BuyAmt / 5)


                            LeverageStragegyData['BuyAmt'] = SliceAmt # 1/5수량을 저장해둠
                            

                            msg = LeverageStragegyData['StockName'] + "  조건을 만족하여 지정가 / 시장가로 매수 시도 합니다!!! "
                            print(msg)
                            line_alert.SendMessage(msg)
                
                            KisKR.MakeBuyLimitOrder(LeverageStragegyData['StockCode'],SliceAmt,CurrentPrice*(1.0 - 0.001)) #20%는 0.1%아래 
                            
                            KisKR.MakeBuyLimitOrder(LeverageStragegyData['StockCode'],SliceAmt,CurrentPrice) #20%는 현재가로 지정가 주문!

                            KisKR.MakeBuyLimitOrder(LeverageStragegyData['StockCode'],SliceAmt,LeverageStragegyData['TargetPrice']) #20%는 돌파가격으로 지정가 주문!
                    
                            KisKR.MakeBuyMarketOrder(LeverageStragegyData['StockCode'],SliceAmt*2,True) #40%만! 시장가로 주문!
                

                                
                            LeverageStragegyData['Status'] = "INVESTING_TRY" #상태 READY(돌파를체크해야하는 준비상태), INVESTING_TRY(돌파해서 주문 들어감), INVESTING(돌파해서 투자중), REST(조건불만족,투자안함,돌파체크안함) 

                


                            msg = LeverageStragegyData['StockName'] + "  조건을 만족하여 지정가 / 시장가로 매수!!! 투자 시작!! "
                            print(msg)
                            line_alert.SendMessage(msg)


            
                        else:
                            print("아직 돌파 안함..")
                            
                

        #파일에 저장
        with open(data_file_path, 'w') as outfile:
            json.dump(LeverageStragegyList, outfile)
else:
    print("Market Is Close!!!!!!!!!!!")

    #line_alert.SendMessage(PortfolioName + "  장이 열려있지 않아요!")


pprint.pprint(DateData)
pprint.pprint(LeverageStragegyList)










