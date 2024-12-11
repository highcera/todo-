# -*- coding: utf-8 -*-
'''

관련 포스팅

최신 동적자산배분 HAA 전략!
https://blog.naver.com/zacra/223067918613


위 포스팅을 꼭 참고하세요!!!

하다가 잘 안되시면 계속 내용이 추가되고 있는 아래 FAQ를 꼭꼭 체크하시고

주식/코인 자동매매 FAQ
https://blog.naver.com/zacra/223203988739

그래도 안 된다면 구글링 해보시고
그래도 모르겠다면 클래스 댓글, 블로그 댓글, 단톡방( https://blog.naver.com/zacra/223111402375 )에 질문주세요! ^^


'''
import KIS_Common as Common
import KIS_API_Helper_US as KisUS
import time
import json
import pprint

import line_alert



#계좌 선택.. "VIRTUAL" 는 모의 계좌!
Common.SetChangeMode("VIRTUAL") #REAL or VIRTUAL


BOT_NAME = Common.GetNowDist() + "_MyHAABot"


#시간 정보를 읽는다
time_info = time.gmtime()
#년월 문자열을 만든다 즉 2022년 9월이라면 2022_9 라는 문자열이 만들어져 strYM에 들어간다!
strYM = str(time_info.tm_year) + "_" + str(time_info.tm_mon)
print("ym_st: " , strYM)



#포트폴리오 이름
PortfolioName = "동적자산배분전략_HAA"




#####################################################################################################################################
#####################################################################################################################################
#####################################################################################################################################


#리밸런싱이 가능한지 여부를 판단!
Is_Rebalance_Go = False


#파일에 저장된 년월 문자열 (ex> 2022_9)를 읽는다
YMDict = dict()

'''
################## 변경된 점 #####################
'''
#파일 경로입니다.
asset_tym_file_path = "/var/autobot/" + BOT_NAME + ".json"
'''
################################################
'''
try:
    with open(asset_tym_file_path, 'r') as json_file:
        YMDict = json.load(json_file)

except Exception as e:
    print("Exception by First")


#만약 키가 존재 하지 않는다 즉 아직 한번도 매매가 안된 상태라면
if YMDict.get("ym_st") == None:

    #리밸런싱 가능! (리밸런싱이라기보다 첫 매수해야 되는 상황!)
    Is_Rebalance_Go = True
    
#매매가 된 상태라면! 매매 당시 혹은 리밸런싱 당시 년월 정보(ex> 2022_9) 가 들어가 있다.
else:
    #그럼 그 정보랑 다를때만 즉 달이 바뀌었을 때만 리밸런싱을 해야 된다
    if YMDict['ym_st'] != strYM:
        #리밸런싱 가능!
        Is_Rebalance_Go = True


#강제 리밸런싱 수행!
#Is_Rebalance_Go = True



#마켓이 열렸는지 여부~!
IsMarketOpen = KisUS.IsMarketOpen()

if IsMarketOpen == True:
    print("Market Is Open!!!!!!!!!!!")
    #영상엔 없지만 리밸런싱이 가능할때만 내게 메시지를 보내자!
    if Is_Rebalance_Go == True:
        line_alert.SendMessage(PortfolioName + " (" + strYM + ") 장이 열려서 포트폴리오 리밸런싱 가능!!")
else:
    print("Market Is Close!!!!!!!!!!!")
    #영상엔 없지만 리밸런싱이 가능할때만 내게 메시지를 보내자!
    if Is_Rebalance_Go == True:
        line_alert.SendMessage(PortfolioName + " (" + strYM + ") 장이 닫혀서 포트폴리오 리밸런싱 불가능!!")




#####################################################################################################################################
#####################################################################################################################################
#####################################################################################################################################


#계좌 잔고를 가지고 온다!
Balance = KisUS.GetBalance()


print("--------------내 보유 잔고---------------------")

pprint.pprint(Balance)

print("--------------------------------------------")
#총 평가금액에서 해당 봇에게 할당할 총 금액비율 1.0 = 100%  0.5 = 50%
InvestRate = 0.5



#기준이 되는 내 총 평가금액에서 투자비중을 곱해서 나온 포트폴리오에 할당된 돈!!
TotalMoney = float(Balance['TotalMoney']) * InvestRate

print("총 포트폴리오에 할당된 투자 가능 금액 : $", TotalMoney)


'''

공격형 자산 :

SPY 
IWM
VEA
VWO
TLT
IEF
DBC -> PDBC
VNQ


안전 자산:

IEF



카나리아 자산:

TIP

'''

##########################################################

#위험 자산 투자시 상위 몇 개를 투자할지
RiskAssetCnt = 4

#안전 자산 투자시 상위 몇 개를 투자할지
SafeAssetCnt = 1


#투자 주식 리스트
MyPortfolioList = list()


RiskCodeList = ['SPY','IWM','VEA','VWO','TLT','IEF','PDBC','VNQ']

for stock_code in RiskCodeList:

    asset = dict()
    asset['stock_code'] = stock_code         #종목코드
    asset['stock_type'] = "RISK"         #공격형(RISK) 자산인지 안전형(SAFE) 자산인지 카나리아(BIRD) 자산인지 여부
    asset['stock_momentum_score'] = 0    #모멘텀 스코어
    asset['stock_target_rate'] = 0   #포트폴리오 목표 비중
    asset['stock_rebalance_amt'] = 0     #리밸런싱 해야 되는 수량
    MyPortfolioList.append(asset)



SafeCodeList = ['IEF','BIL'] #BIL에 투자하진 않지만 현금 모멘텀 계산

for stock_code in SafeCodeList:

    asset = dict()
    asset['stock_code'] = stock_code          #종목코드
    asset['stock_type'] = "SAFE"         #공격형(RISK) 자산인지 안전형(SAFE) 자산인지 카나리아(BIRD) 자산인지 여부
    asset['stock_momentum_score'] = 0    #모멘텀 스코어
    asset['stock_target_rate'] = 0   #포트폴리오 목표 비중
    asset['stock_rebalance_amt'] = 0     #리밸런싱 해야 되는 수량
    MyPortfolioList.append(asset)


BirdCodeList = ['TIP'] 

for stock_code in BirdCodeList:

    asset = dict()
    asset['stock_code'] = stock_code         #종목코드
    asset['stock_type'] = "BIRD"         #공격형(RISK) 자산인지 안전형(SAFE) 자산인지 카나리아(BIRD) 자산인지 여부
    asset['stock_momentum_score'] = 0    #모멘텀 스코어
    asset['stock_target_rate'] = 0   #포트폴리오 목표 비중
    asset['stock_rebalance_amt'] = 0     #리밸런싱 해야 되는 수량
    MyPortfolioList.append(asset)






##########################################################

print("--------------내 보유 주식---------------------")
#그리고 현재 이 계좌에서 보유한 주식 리스트를 가지고 옵니다!
MyStockList = KisUS.GetMyStockList()
pprint.pprint(MyStockList)
print("--------------------------------------------")
##########################################################




print("--------------리밸런싱 계산 ---------------------")


print("-------------- 모멘텀 스코어 계산 ---------------------")

#모든 자산의 모멘텀 스코어 구하기! 
for stock_info in MyPortfolioList:
    print("....")
    stock_code = stock_info['stock_code']
    stock_type = stock_info['stock_type']

    df = Common.GetOhlcv("US",stock_code)


    Now_Price = Common.GetCloseData(df,-1) #현재가
    One_Price = Common.GetCloseData(df,-20) #한달 전
    Three_Price = Common.GetCloseData(df,-60) #3달전
    Six_Price = Common.GetCloseData(df,-120) #6달전
    Twelve_Price = Common.GetCloseData(df,-240) #1년전

    CurrentMa1Y = Common.GetMA(df,240,-1) #12개월 이동평균


    print(stock_code, Now_Price, One_Price, Three_Price, Six_Price, Twelve_Price)


    MomentumScore = (((Now_Price - One_Price) / One_Price)) + (((Now_Price - Three_Price) / Three_Price)) + (((Now_Price - Six_Price) / Six_Price)) + (((Now_Price - Twelve_Price) / Twelve_Price))


    stock_info['stock_momentum_score'] = MomentumScore

    print(stock_code," -> MomentumScore: ",MomentumScore)






print("-------------- 투자 자산과 비중 결정 ---------------------")

RiskList = list() #공격 자산 리스트
SafeList = list() #안전 자산 리스트


GoAttack = True

for stock_info in MyPortfolioList:

    pprint.pprint(stock_info)

    #카나리아 자산인데 
    if stock_info['stock_type'] == "BIRD":
        #모멘텀 스코어가 마이너스다? 그러면 안전자산에 투자해야 겠넹!
        if stock_info['stock_momentum_score'] < 0:
            GoAttack = False

    elif stock_info['stock_type'] == "RISK":

        RiskList.append(stock_info)

    elif stock_info['stock_type'] == "SAFE":

        SafeList.append(stock_info)





#안전 자산 중 가장 모멘텀 스코어가 높은거를 SafeAssetCnt개 만큼 순서대로 구한다! - IEF 혹은 BIL
Safedata = sorted(SafeList, key=lambda stock_info: (stock_info['stock_momentum_score']), reverse= True)
pprint.pprint(Safedata)


SafeTopStockCodeList = list()

for i in range(0,SafeAssetCnt):
    SafeTopStockCodeList.append(Safedata[i]['stock_code'])





#위험 자산 중 가장 모멘텀 스코어가 높은 상위 RiskAssetCnt개를 구한다. HAA 기본 전략은 4개!
Riskdata = sorted(RiskList, key=lambda stock_info: (stock_info['stock_momentum_score']), reverse= True)
pprint.pprint(Riskdata)

RiskTopStockCodeList = list()

for i in range(0,RiskAssetCnt):
    RiskTopStockCodeList.append(Riskdata[i]['stock_code'])





###############################
#최종 투자해야 자산 코드 리스트!!
FinalSelectedList = list()
###############################

Is_Safe_Add_Rate = 0 #안전자산 비중이 추가되는 거

for stock_info in MyPortfolioList:

    stock_code = stock_info['stock_code']

    if GoAttack == True:

        if stock_info['stock_type'] == "RISK":
            #가장 수익률 높은 위험자산 리스트에 포함이 되어 있다면!
            if Common.CheckStockCodeInList(RiskTopStockCodeList,stock_code) == True:
                
                Target_rate = 100.0 / float(RiskAssetCnt) 
                
                if stock_info['stock_momentum_score'] > 0: #양수 일때만 투자 
                    stock_info['stock_target_rate'] = Target_rate
                    FinalSelectedList.append(stock_code) #최종 선택에 넣어준다!
                else:       #음수면 안전자산으로 비중을 넘기자!
                    Is_Safe_Add_Rate += Target_rate
                    stock_info['stock_target_rate'] = 0


    else: #안전 자산에만 투자! 
        if stock_info['stock_type'] == "SAFE":
            #가장 수익률 높은 안전자산 리스트에 포함이 되어 있다면!
            if Common.CheckStockCodeInList(SafeTopStockCodeList,stock_code) == True:
                
                if stock_code == 'BIL': #가장 모멘텀 좋은 것이 현금이다. 
                    stock_info['stock_target_rate'] = 0 #0으로 만들어 자연스레 현금 보유!!
                    
                else: #그게 아니라면 IEF이다. 
           
                    Target_rate = 100.0 / float(SafeAssetCnt) #굳이 이럴 필요는 없지만 안전자산을 더 추가하고픈 확장을 위해.
        
                    stock_info['stock_target_rate'] = Target_rate
                    FinalSelectedList.append(stock_code) #최종 선택에 넣어준다!

                        
                    
#투자 결정된 공격자산 중 모멘텀 스코어가 음수여서 안전자산 비중으로 넘어간 것들..
if Is_Safe_Add_Rate > 0:
    
    #다시 for문을 돌면서 
    for stock_info in MyPortfolioList:

        stock_code = stock_info['stock_code']
        
        #안전자산에 비중을 추가 해준다!
        if stock_info['stock_type'] == "SAFE":
            if Common.CheckStockCodeInList(SafeTopStockCodeList,stock_code) == True:
                
                #가장 모멘텀 좋은 것이 현금이 아닐 때만 비중을 추가해서 안전자산(IEF)에 투자한다!
                if stock_code != 'BIL':
                
                    Target_rate = Is_Safe_Add_Rate / float(SafeAssetCnt)
        
                    stock_info['stock_target_rate'] += Target_rate
                    FinalSelectedList.append(stock_code) #최종 선택에 넣어준다!

                    
print("----RiskTopStockCodeList ASSET!-----")
pprint.pprint(RiskTopStockCodeList)
print("----SafeTopStockCodeList ASSET!-----")
pprint.pprint(SafeTopStockCodeList)
    

print("----FINAL SELECTED ASSET!-----")
pprint.pprint(FinalSelectedList)
print("-----------------------------")





strResult = "-- 현재 포트폴리오 상황 --\n"

#매수된 자산의 총합!
total_stock_money = 0

#현재 평가금액 기준으로 각 자산이 몇 주씩 매수해야 되는지 계산한다 (포트폴리오 비중에 따라) 이게 바로 리밸런싱 목표치가 됩니다.
for stock_info in MyPortfolioList:

    #내주식 코드
    stock_code = stock_info['stock_code']
    #매수할 자산 보유할 자산의 비중을 넣어준다!
    stock_target_rate = float(stock_info['stock_target_rate']) / 100.0


    #기준이 된 카나리아 자산 ETF와 현금(BIL)은 아무것도 안한다
    if stock_info['stock_type'] == "BIRD" or stock_code == "BIL":
        continue

    #위험자산에 투자 해야 하는 상태
    if GoAttack == True:

        #위험자산에 투자해야 되는데 안전자산에 투자하는 것을 스킵하려면 안전자산으로 넘어간 비중이 없어야 한다.
        if Is_Safe_Add_Rate == 0:
            #위험자산에 IEF가 속해 있다면 비중에 따라 매수매도가 될테니깐 안전자산 체크시 매도를 피합니다!
            if 'IEF' in RiskTopStockCodeList and stock_info['stock_type'] == "SAFE" and stock_code == "IEF":
                continue
            
    #안전자산에 투자 해야 하는 상태
    else:
        #안전자산에 IEF가 속해 있다면 비중에 따라 매수매도가 될테니깐 위험자산 체크시 매도를 피합니다!
        if 'IEF' in SafeTopStockCodeList and stock_info['stock_type'] == "RISK" and stock_code == "IEF":
            continue


    #현재가!
    CurrentPrice = KisUS.GetCurrentPrice(stock_code)


    
    stock_name = ""
    stock_amt = 0 #수량
    stock_avg_price = 0 #평단
    stock_eval_totalmoney = 0 #총평가금액!
    stock_revenue_rate = 0 #종목 수익률
    stock_revenue_money = 0 #종목 수익금

 

    #내가 보유한 주식 리스트에서 매수된 잔고 정보를 가져온다
    for my_stock in MyStockList:
        if my_stock['StockCode'] == stock_code:
            stock_name = my_stock['StockName']
            stock_amt = int(my_stock['StockAmt'])
            stock_avg_price = float(my_stock['StockAvgPrice'])
            stock_eval_totalmoney = float(my_stock['StockNowMoney'])
            stock_revenue_rate = float(my_stock['StockRevenueRate'])
            stock_revenue_money = float(my_stock['StockRevenueMoney'])

            break

    print("##### stock_code: ", stock_code)

    #주식의 총 평가금액을 더해준다
    total_stock_money += stock_eval_totalmoney

    #현재 비중
    stock_now_rate = 0

    #잔고에 있는 경우 즉 이미 매수된 주식의 경우
    if stock_amt > 0:


        stock_now_rate = round((stock_eval_totalmoney / TotalMoney),3)

        print("---> NowRate:", round(stock_now_rate * 100.0,2), "%")

        #최종 선택된 자산리스트에 포함되어 있다면 비중대로 보유해야 한다! 리밸린싱!
        if Common.CheckStockCodeInList(FinalSelectedList,stock_code) == True:


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

                        #팔아야 되는 상황에서는 현재 주식수량에서 매도할 수량을 뺀 값이 1주는 남아 있어야 한다
                        #그래야 포트폴리오 상에서 아예 사라지는 걸 막는다!
                        if stock_amt - GapAmt >= 1:
                            stock_info['stock_rebalance_amt'] = -GapAmt

                    #갭이 양수라면 비중이 더 적으니 사야되는 상황!
                    else:  
                        stock_info['stock_rebalance_amt'] = GapAmt


        #선택된 자산이 아니라면 전 수량 다 팔아야 한다
        else:
            stock_info['stock_rebalance_amt'] = -stock_amt



    #잔고에 없는 경우
    else:

        #최종 선택된 자산리스트에 포함되어 있다면 비중대로 매수해야 한다!
        if Common.CheckStockCodeInList(FinalSelectedList,stock_code) == True:

            print("---> NowRate: 0%")

            #잔고가 없다면 첫 매수다! 비중대로 매수할 총 금액을 계산한다 
            BuyMoney = TotalMoney * stock_target_rate


            #매수할 수량을 계산한다!
            BuyAmt = int(BuyMoney / CurrentPrice)

            #포트폴리오에 들어간건 일단 무조건 1주를 사주자... 아니라면 아래 2줄 주석처리
        # if BuyAmt <= 0:
            #    BuyAmt = 1

            stock_info['stock_rebalance_amt'] = BuyAmt

        #선택된 최종 자산이 아니라면 아무것도 안하면 된다!
        else:
            print("Do nothing")
        

        
        
        
        
        
    #라인 메시지랑 로그를 만들기 위한 문자열 
    line_data =  (">> " + stock_code + " << \n비중: " + str(round(stock_now_rate * 100.0,2)) + "/" + str(round(stock_target_rate * 100.0,2)) 
    + "% \n수익: $" + str(stock_revenue_money) + "("+ str(round(stock_revenue_rate,2)) 
    + "%) \n총평가금액: $" + str(round(stock_eval_totalmoney,2)) 
    + "\n리밸런싱수량: " + str(stock_info['stock_rebalance_amt']) + "\n----------------------\n")

    #만약 아래 한번에 보내는 라인메시지가 짤린다면 아래 주석을 해제하여 개별로 보내면 됩니다
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

##########################################################


#리밸런싱이 가능한 상태여야 하고 매수 매도는 장이 열려있어야지만 가능하다!!!
if Is_Rebalance_Go == True and IsMarketOpen == True:

    line_alert.SendMessage(PortfolioName + " (" + strYM + ") 리밸런싱 시작!!")

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
            


            #현재가의 1%아래의 가격으로 지정가 매도.. (그럼 1%아래 가격보다 큰 가격의 호가들은 모두 체결되기에 제한있는 시장가 매도 효과)
            CurrentPrice *= 0.99
            pprint.pprint(KisUS.MakeSellLimitOrder(stock_code,abs(rebalance_amt),CurrentPrice))

            #######################################################
            #지정가로 하려면 아래 함수 활용! 주식 클래스 완강 필요!
            #Common.AutoLimitDoAgain(BOT_NAME,"US",stock_code,CurrentPrice,rebalance_amt,"DAY_END")


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



            #현재가의 1%위의 가격으로 지정가 매수.. (그럼 1% 위 가격보다 작은 가격의 호가들은 모두 체결되기에 제한있는 시장가 매수 효과)
            CurrentPrice *= 1.01
            pprint.pprint(KisUS.MakeBuyLimitOrder(stock_code,rebalance_amt,CurrentPrice))
            
            #######################################################
            #지정가로 하려면 아래 코드로 매수! 주식 클래스 완강 필요!
            #Common.AutoLimitDoAgain(BOT_NAME,"US",stock_code,CurrentPrice,rebalance_amt,"DAY_END")
                    



    print("--------------------------------------------")

    #########################################################################################################################
    #첫 매수던 리밸런싱이던 매매가 끝났으면 이달의 리밸런싱은 끝이다. 해당 달의 년달 즉 22년 9월이라면 '2022_9' 라는 값을 파일에 저장해 둔다! 
    #파일에 저장하는 부분은 여기가 유일!!!!
    YMDict['ym_st'] = strYM
    with open(asset_tym_file_path, 'w') as outfile:
        json.dump(YMDict, outfile)
    #########################################################################################################################
        
    line_alert.SendMessage(PortfolioName + " (" + strYM + ") 리밸런싱 완료!!")
    print("------------------리밸런싱 끝---------------------")

