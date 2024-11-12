# https://blog.naver.com/zacra/223597500754

import KIS_Common as Common
import pandas as pd
import KIS_API_Helper_US as KisUS
import time
import json
import pprint
from datetime import datetime, timedelta

import line_alert 

#계좌 선택.. "VIRTUAL" 는 모의 계좌!
Common.SetChangeMode("REAL") #REAL or VIRTUAL

#flot value를 소수 0자리, 천단위 , 표시하여 formated str을 리턴한다!
def GetFmtStr(Value): 
    return format(int(round(Value, 0)), ',')

def GetFmtStr2(Value): 
    # return round(Value, 2)
    return format((round(Value, 2)), ',')

BOT_NAME = Common.GetNowDist() + "_Ungjub_US"

#시간 정보를 읽는다
time_info = time.gmtime()
#년월 문자열을 만든다 즉 2022년 9월이라면 2022_9 라는 문자열이 만들어져 strYM에 들어간다!
strYMD = str(time_info.tm_year) + "_" + str(time_info.tm_mon)+ "_" + str(time_info.tm_mday)
print("ymd_st: " , strYMD)

#포트폴리오 이름
PortfolioName = "웅줍오즐전략_US"

#리밸런싱이 가능한지 여부를 판단!
Is_Rebalance_Go = False

#마켓이 열렸는지 여부~!
IsMarketOpen = KisUS.IsMarketOpen()

#계좌 잔고를 가지고 온다!
Balance = KisUS.GetBalance()

print("--------------내 보유 잔고---------------------")
pprint.pprint(Balance)
print("--------------------------------------------")

#총 평가금액에서 해당 봇에게 할당할 총 금액비율 1.0 = 100%  0.5 = 50%
InvestRate = 0.5

FixRate = 0.1 #각 자산별 할당 금액의 10%를 고정비중으로 투자함!
DynamicRate = 0.5 #각 자산별 할당 금액의 50%의 투자 비중은 모멘텀에 의해 정해짐!
#위의 경우 FixRate + DynamicRate = 0.6 즉 60%이니깐 매도신호 시 40%비중은 무조건 팔도록 되어 있다.
#위 두 값이 모두 0이라면 기존처럼 매도신호시 모두 판다!!

InvestStockList = list()

InvestStockList.append({"stock_code":"TQQQ", "small_ma":4 , "big_ma":53, "invest_rate":1.0})
# InvestStockList.append({"stock_code":"PFIX", "small_ma":15 , "big_ma":38, "invest_rate":0.15})
# InvestStockList.append({"stock_code":"TMF", "small_ma":15 , "big_ma":47, "invest_rate":0.15}) 

#기준이 되는 내 총 평가금액에서 투자비중을 곱해서 나온 포트폴리오에 할당된 돈!!
TotalMoney = float(Balance['TotalMoney']) * InvestRate
print("총 포트폴리오에 할당된 투자 가능 금액 : $", TotalMoney)

#현재 투자중 상태인 리스트! (모두 파는게 아니라 부분 매도할 경우 매매 기준으로 삼기 위해 이 것이 필요하다.)
FileStockList = list()

#파일 경로입니다.
invest_file_path = "/var/autobot/"+BOT_NAME+"_List.json"
# invest_file_path = BOT_NAME+"_List.json"

try:
    #이 부분이 파일을 읽어서 리스트에 넣어주는 로직입니다. 
    with open(invest_file_path, 'r') as json_file:
        FileStockList = json.load(json_file)

except Exception as e:
    #처음에는 파일이 존재하지 않을테니깐 당연히 예외처리가 됩니다!
    print("Exception by First")

#투자 주식 리스트
MyPortfolioList = list()

for stock_info in InvestStockList:
    asset = dict()
    asset['stock_code'] = stock_info['stock_code']         #종목코드
    asset['small_ma'] = stock_info['small_ma']  
    asset['big_ma'] = stock_info['big_ma']  
    asset['stock_target_rate'] = stock_info['invest_rate']      #비중..
    asset['stock_rebalance_amt'] = 0  #리밸런싱 수량
    asset['status'] = 'NONE'
    MyPortfolioList.append(asset)

print("--------------내 보유 주식---------------------")
#그리고 현재 이 계좌에서 보유한 주식 리스트를 가지고 옵니다!
AccStockList = KisUS.GetMyStockList()
pprint.pprint(AccStockList)
print("--------------------------------------------")

print("--------------리밸런싱 계산 ---------------------")

stock_df_list = []

for stock_info in InvestStockList: 
    stock_code = stock_info['stock_code']
  
    df = Common.GetOhlcv("US", stock_code,300)
    df['prevClose'] = df['close'].shift(1)

    macd_before = Common.GetMACD(df,-2) #이전캔들의 MACD
    macd = Common.GetMACD(df,-1) #현재캔들의 MACD

    ############# 이동평균선! ###############
    ma_dfs = []

    # 이동 평균 계산
    for ma in range(3, 201):
        ma_df = df['close'].rolling(ma).mean().rename(str(ma) + 'ma_before').shift(1)
        ma_dfs.append(ma_df)
        
        ma_df = df['close'].rolling(ma).mean().rename(str(ma) + 'ma_before2').shift(2)
        ma_dfs.append(ma_df)
    # 이동 평균 데이터 프레임을 하나로 결합
    ma_df_combined = pd.concat(ma_dfs, axis=1)
    
    # 원본 데이터 프레임과 결합
    df = pd.concat([df, ma_df_combined], axis=1)
    df.dropna(inplace=True) #데이터 없는건 날린다!
    
    date = df.iloc[-1].name
    stock_data = df[(df.index == date)]
     
    stock_amt = 0 #수량

    #내가 보유한 주식 리스트에서 매수된 잔고 정보를 가져온다
    for my_stock in AccStockList:
        if my_stock['StockCode'] == stock_code:
            stock_amt = int(my_stock['StockAmt'])
            break
    
    ma1 = stock_info['small_ma']
    ma2 = stock_info['big_ma']

    small_ma = int(ma1)
    big_ma = int(ma2)   
    
    NowClosePrice = stock_data['close'].values[0]
    
    #MACD값을 구해줍니다!
    #MACD함수는 아래와 같이 딕셔너리 형식으로 값을 리턴하며 macd는 MACD값, macd_siginal값이 시그널값, ocl이 오실레이터 값이 됩니다
    print("\n------------- MACD -------------------")
    macd_before = Common.GetMACD(df,-2) #이전캔들의 MACD
    print("before - MACD:",macd_before['macd'], ", MACD_SIGNAL:", macd_before['macd_siginal'],", ocl:", macd_before['ocl'])
    print("-----------------------------------------------")
    macd = Common.GetMACD(df,-1) #현재캔들의 MACD
    print("now - MACD:",macd['macd'], ", MACD_SIGNAL:", macd['macd_siginal'],", ocl:", macd['ocl'])
    print("-----------------------------------------------\n")

    msg1 = "\nSmall(4) : " + GetFmtStr2(stock_data[str(small_ma)+'ma_before'].values[0]) + ", Big(53): " + GetFmtStr2(stock_data[str(big_ma)+'ma_before'].values[0])
    msg2 = "\nClose : " + GetFmtStr2(NowClosePrice)
    msg3 = "\n5일선 : " + GetFmtStr2(stock_data['5ma_before'].values[0]) + ", 20일선 : " + GetFmtStr2(stock_data['20ma_before'].values[0]) + ", 60일선 : " + GetFmtStr2(stock_data['60ma_before'].values[0]) + ", 120일선 : " + GetFmtStr2(stock_data['120ma_before'].values[0])
    msg4 = "\nbefore - MACD : " + GetFmtStr2(macd_before['macd']) + ", before MACD_SIGNAL:" + GetFmtStr2(macd_before['macd_siginal']) + ", before MACD_OSC :" + GetFmtStr2(macd_before['ocl'])
    msg5 = "\nMACD : " + GetFmtStr2(macd['macd']) + ", MACD_SIGNAL:" + GetFmtStr2(macd['macd_siginal']) + ", MACD_OSC :" + GetFmtStr2(macd['ocl']) + "\n"
    msg = msg1 + msg2 + msg3 + msg4 + msg5
   
    print(msg1, msg2, msg3, msg4, msg5)  
    line_alert.SendMessage(msg) 
    
    if stock_data[str(small_ma)+'ma_before'].values[0] > stock_data[str(big_ma)+'ma_before'].values[0]:
        print("보유!! (추가 매수금지) - 적정 (일부) 매도시점 검토 중")
    else:
        print("일부 매도 후 매수 시점 모니터링")
        if NowClosePrice < stock_data['20ma_before'].values[0]:
            print("20일선 하향 돌파, 매수 optional!")
        if NowClosePrice < stock_data['60ma_before'].values[0]:
            print("20% 5회 분할 매수")
        if NowClosePrice < stock_data['120ma_before'].values[0]:
            print("30% 5회 분할 매수")
        # if NowClosePrice < RSI_30
        #     print("30% 5회 분할 매수")
        
        # MACD 매수 시점 점검
        if macd['macd_siginal'] < 0:
            print("MACD negative!")
            if (macd_before['macd_siginal'] <= macd_before['macd']) and (macd['macd_siginal'] > macd['macd']): # MACD golden cross 
                print("MACD Golden Cross!! 50% 5회 분할 매수")
            else:
                print("MACD signal is still under baseline!")
        else: 
            print("MACD positive!")
    
         # print("before - MACD:",macd_before['macd'], ", MACD_SIGNAL:", macd_before['macd_siginal'],", ocl:", macd_before['ocl'])
    # print("-----------------------------------------------")
    macd = Common.GetMACD(df,-1) #현재캔들의 MACD
    # print("now - MACD:",macd['macd'], ", MACD_SIGNAL:", macd['macd_siginal'],", ocl:", macd['ocl'])
    # print("-----------------------------------------------\n")
    
    
''' 
    print(ma_df_combined)    
    
    ########################################
    #200거래일 평균 모멘텀
    specific_days = list()

    for i in range(1,11):
        st = i * 20
        specific_days.append(st)

    for day in specific_days:
        column_name = f'Momentum_{day}'
        df[column_name] = (df['prevClose'] > df['close'].shift(day)).astype(int)

    df['Average_Momentum'] = df[[f'Momentum_{day}' for day in specific_days]].sum(axis=1) / 10
    df.dropna(inplace=True) #데이터 없는건 날린다!
    data_dict = {stock_code: df}
    stock_df_list.append(data_dict)
        
    print("---stock_code---", stock_code , " len ",len(df))
    pprint.pprint(df)

combined_df = pd.concat([list(data_dict.values())[0].assign(stock_code=stock_code) for data_dict in stock_df_list for stock_code in data_dict])
combined_df.sort_index(inplace=True)
pprint.pprint(combined_df)
print(" len(combined_df) ", len(combined_df))

date = combined_df.iloc[-1].name

TodayRebalanceList = list()

#리밸런싱 수량을 확정한다!
for stock_info in MyPortfolioList:
    stock_code = stock_info['stock_code']
    stock_data = combined_df[(combined_df.index == date) & (combined_df['stock_code'] == stock_code)] 

    if len(stock_data) == 1:
        stock_amt = 0 #수량

        #내가 보유한 주식 리스트에서 매수된 잔고 정보를 가져온다
        for my_stock in AccStockList:
            if my_stock['StockCode'] == stock_code:
                stock_amt = int(my_stock['StockAmt'])
                break

        NowClosePrice = stock_data['close'].values[0]
        
        ma1 = stock_info['small_ma']
        ma2 = stock_info['big_ma']

        small_ma = int(ma1)
        big_ma = int(ma2)
        
        SellRate0 = FixRate + (stock_data['Average_Momentum'].values[0] * DynamicRate)
        print(stock_data['Average_Momentum'].values[0], SellRate0)
        msg = "Small : " + GetFmtStr2(stock_data[str(small_ma)+'ma_before'].values[0]) + ", Big : " + GetFmtStr2(stock_data[str(big_ma)+'ma_before'].values[0])
        # msg3 = "\nMomentum : " + GetFmtStr3(stock_data['Average_Momentum'].values[0]) + "SellRate : " + GetFmtStr3(SellRate0)
        msg2 = "\nMomentum : " + str(stock_data['Average_Momentum'].values[0]) + "SellRate : " + str(SellRate0)
        print(msg, msg2)         

        print("File Stock List : ", FileStockList)   
        #이평선에 의해 매도처리 해야 된다!!! 
        if stock_code in FileStockList and stock_amt > 0:
            print(stock_code, " 보유중... 매도 조건 체크!!")
            
            if stock_data[str(small_ma)+'ma_before'].values[0] < stock_data[str(big_ma)+'ma_before'].values[0] and stock_data[str(small_ma)+'ma_before2'].values[0] > stock_data[str(small_ma)+'ma_before'].values[0]:
                Is_Rebalance_Go = True
                
                SellRate = FixRate + (stock_data['Average_Momentum'].values[0] * DynamicRate) 
                
                stock_info['stock_target_rate'] *= SellRate
                stock_info['status'] = 'SELL'
                print(stock_code, "매도조건 만족!!!", stock_info['stock_target_rate']*100, "% 비중을 맞춰서 매매해야 함!")
                
                TodayRebalanceList.append(stock_code)
    
        if stock_code not in FileStockList: 
            if stock_data[str(small_ma)+'ma_before'].values[0] > stock_data[str(big_ma)+'ma_before'].values[0] and stock_data[str(small_ma)+'ma_before2'].values[0] < stock_data[str(small_ma)+'ma_before'].values[0]:
                Is_Rebalance_Go = True
                
                stock_info['status'] = 'BUY'
                print(stock_code, "매수조건 만족!!!", stock_info['stock_target_rate']*100, "% 비중을 맞춰서 매매해야 함!")
                
                TodayRebalanceList.append(stock_code)
        
print("My Portfolio List : ", MyPortfolioList) 
strResult = "-- 현재 포트폴리오 상황 --\n"

#매수된 자산의 총합!
total_stock_money = 0

#현재 평가금액 기준으로 각 자산이 몇 주씩 매수해야 되는지 계산한다 (포트폴리오 비중에 따라) 이게 바로 리밸런싱 목표치가 됩니다.
for stock_info in MyPortfolioList:

    #내주식 코드
    stock_code = stock_info['stock_code']
    
    #현재가!
    CurrentPrice = KisUS.GetCurrentPrice(stock_code)

    stock_name = ""
    stock_amt = 0 #수량
    stock_avg_price = 0 #평단
    stock_eval_totalmoney = 0 #총평가금액!
    stock_revenue_rate = 0 #종목 수익률
    stock_revenue_money = 0 #종목 수익금

    #내가 보유한 주식 리스트에서 매수된 잔고 정보를 가져온다
    for my_stock in AccStockList:
        if my_stock['StockCode'] == stock_code:
            stock_name = my_stock['StockName']
            stock_amt = int(my_stock['StockAmt'])
            stock_avg_price = float(my_stock['StockAvgPrice'])
            stock_eval_totalmoney = float(my_stock['StockNowMoney'])
            stock_revenue_rate = float(my_stock['StockRevenueRate'])
            stock_revenue_money = float(my_stock['StockRevenueMoney'])
            break

    print("##### stock_code: ", stock_code)
    
    #매수할 자산 보유할 자산의 비중을 넣어준다!
    stock_target_rate = float(stock_info['stock_target_rate']) 

    #오늘 리밸런싱 대상이 아닌 종목인데 보유비중이 한개도 없다???
    if stock_code not in TodayRebalanceList:
        if stock_amt == 0:
            stock_target_rate *= FixRate #보유하고자 했던 고정비중은 매수하도록 한다!!
            stock_info['status'] = 'BUY_S'
            msg = PortfolioName + " 투자 비중이 없어 "+stock_code+" 종목의 할당 비중의 1/10을 투자하도록 함!"
            print(msg)
            line_alert.SendMessage(msg)
        
    #주식의 총 평가금액을 더해준다
    total_stock_money += stock_eval_totalmoney

    #현재 비중
    stock_now_rate = 0

    #잔고에 있는 경우 즉 이미 매수된 주식의 경우
    if stock_amt > 0:

        stock_now_rate = round((stock_eval_totalmoney / TotalMoney),3)
        print("---> NowRate:", round(stock_now_rate * 100.0,2), "%")
        
        if stock_info['status'] != 'NONE':
            if stock_target_rate == 0:
                stock_info['stock_rebalance_amt'] = -stock_amt
                print("!!!!!!!!! SELL")
            else:
                #목표한 비중이 다르다면!!
                if stock_now_rate != stock_target_rate:
                    #갭을 구한다!!!
                    GapRate = stock_target_rate - stock_now_rate
                    
                    #그래서 그 갭만큼의 금액을 구한다
                    GapMoney = TotalMoney * abs(GapRate) 
                    
                    #현재가로 나눠서 몇주를 매매해야 되는지 계산한다
                    GapAmt = GapMoney / CurrentPrice

                    #수량이 1보다 커야 리밸러싱을 할 수 있다!! 즉 그 전에는 리밸런싱 불가 
                    if GapAmt >= 1.0:
                        GapAmt = int(GapAmt)

                        #갭이 음수라면! 비중이 더 많으니 팔아야 되는 상황!!! 
                        if GapRate < 0:
                            print("this!!!")
                            stock_info['stock_rebalance_amt'] = -GapAmt

                        #갭이 양수라면 비중이 더 적으니 사야되는 상황!
                        else:  
                            stock_info['stock_rebalance_amt'] = GapAmt

    #잔고에 없는 경우
    else:
        print("---> NowRate: 0%")
        if stock_target_rate > 0:
            if stock_info['status'] == 'BUY' or stock_info['status'] == 'BUY_S':
                
                # 비중대로 매수할 총 금액을 계산한다 
                BuyMoney = TotalMoney * stock_target_rate
                
                #매수할 수량을 계산한다!
                BuyAmt = int(BuyMoney / CurrentPrice)

                if BuyAmt <= 0:
                    BuyAmt = 1

                stock_info['stock_rebalance_amt'] = BuyAmt
        
    #라인 메시지랑 로그를 만들기 위한 문자열 
    line_data =  (">> " + stock_code + " << \n비중: " + str(round(stock_now_rate * 100.0,2)) + "/" + str(round(stock_target_rate * 100.0,2)) 
    + "% \n수익: $" + str(stock_revenue_money) + "("+ str(round(stock_revenue_rate,2)) 
    + "%) \n총평가금액: $" + str(round(stock_eval_totalmoney,2)) 
    + "\n현재보유수량: " + str(stock_amt) 
    + "\n리밸런싱수량: " + str(stock_info['stock_rebalance_amt']) + "\n----------------------\n")

    if Is_Rebalance_Go == True:
        line_alert.SendMessage(line_data)
    strResult += line_data

##########################################################
print("--------------리밸런싱 해야 되는 수량-------------")

data_str = "\n" + PortfolioName + "\n" +  strResult + "\n포트폴리오할당금액: $" + str(round(TotalMoney,2)) + "\n매수한자산총액: $" + str(round(total_stock_money,2))

#결과를 출력해 줍니다!
print(data_str)

#영상엔 없지만 리밸런싱이 가능할때만 내게 메시지를 보내자!
#if Is_Rebalance_Go == True:
#    line_alert.SendMessage(data_str)
    
#만약 위의 한번에 보내는 라인메시지가 짤린다면 아래 주석을 해제하여 개별로 보내면 됩니다
if Is_Rebalance_Go == True:
    line_alert.SendMessage("\n포트폴리오할당금액: $" + str(round(TotalMoney,2)) + "\n매수한자산총액: $" + str(round(total_stock_money,2)))

print("--------------------------------------------")

if Is_Rebalance_Go == True:
    if IsMarketOpen == False:
        msg = PortfolioName + " 매매할 종목이 있어 리밸런싱 수행 해야 하지만 지금은 장이 열려있지 않아요!"
        print(msg)
        line_alert.SendMessage(msg)


#리밸런싱이 가능한 상태여야 하고 매수 매도는 장이 열려있어야지만 가능하다!!!
if Is_Rebalance_Go == True and IsMarketOpen == True:

    line_alert.SendMessage(PortfolioName + " 리밸런싱 시작!!")

    print("------------------리밸런싱 시작  ---------------------")


    #이제 목표치에 맞게 포트폴리오를 조정하면 되는데
    #매도를 해야 돈이 생겨 매수를 할 수 있을 테니
    #먼저 매도를 하고
    #그 다음에 매수를 해서 포트폴리오를 조정합니다!

    print("--------------매도 (리밸런싱 수량이 마이너스인거)---------------------")

    for stock_info in MyPortfolioList:

        #내주식 코드
        stock_code = stock_info['stock_code']
        rebalance_amt = stock_info['stock_rebalance_amt']

        #리밸런싱 수량이 마이너스인 것을 찾아 매도 한다!
        if rebalance_amt < 0:
                    
            #현재가!
            CurrentPrice = KisUS.GetCurrentPrice(stock_code)

            #현재가보다 아래에 매도 주문을 넣음으로써 시장가로 매도
            CurrentPrice *= 0.99
            pprint.pprint(KisUS.MakeSellLimitOrder(stock_code,abs(rebalance_amt),CurrentPrice))

    print("--------------------------------------------")
    #3초 정도 쉬어준다
    time.sleep(3.0)

    print("--------------매수 ---------------------")

    for stock_info in MyPortfolioList:

        #내주식 코드
        stock_code = stock_info['stock_code']
        rebalance_amt = stock_info['stock_rebalance_amt']

        #리밸런싱 수량이 플러스인 것을 찾아 매수 한다!
        if rebalance_amt > 0:
                    
            #현재가!
            CurrentPrice = KisUS.GetCurrentPrice(stock_code)

            #현재가보다 위에 매수 주문을 넣음으로써 시장가로 매수
            CurrentPrice *= 1.01
            data = KisUS.MakeBuyLimitOrder(stock_code,rebalance_amt,CurrentPrice)
            
            print(data)
            line_alert.SendMessage(PortfolioName + " " + stock_code + " " + str(data))
   
    print("--------------------------------------------")
    for stock_info in MyPortfolioList:
        stock_code = stock_info['stock_code']
        if stock_info['status'] == 'BUY':
        
            FileStockList.append(stock_code)

            line_alert.SendMessage(PortfolioName + " " + stock_code + " 전략 보유 처리!")
            
        if stock_info['status'] == 'SELL':
        
            FileStockList.remove(stock_code)
                
            line_alert.SendMessage(PortfolioName + " " + stock_code + " 전략 미보유 처리!")
            
    #파일에 저장
    with open(invest_file_path, 'w') as outfile:
        json.dump(FileStockList, outfile)

    line_alert.SendMessage(PortfolioName + "  리밸런싱 완료!!")
    print("------------------리밸런싱 끝---------------------")
    
    '''