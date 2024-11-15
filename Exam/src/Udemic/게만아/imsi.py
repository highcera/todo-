# dic = [
# {'name':'ma120_before', 'value':70.59},
# {'name':'ma60_before', 'value':71.30},
# {'name':'ma20_before', 'value':76.31},
# {'name':'ma10_before', 'value':78.49},
# {'name':'prev_close', 'value':80.06}

# ]
# # 딕셔너리의 age 키 값을 기준으로 내림차순 정렬
# print("[전일 종가 및 이평선 위치 확인]")
# sorted_dic = sorted(dic, key = lambda x:x['value'], reverse=True) 
# for ma in sorted_dic:
#     print(ma['name'], " : ", ma['value']) 

DivNum = 4
MagicDataInfo = {"StockCode": "TQQQ", "IsReady": True, "MagicDataList": [{"Number": 1, "EntryPrice": 0, "EntryAmt": 4, "IsBuy": True}, {"Number": 2, "EntryPrice": 0, "EntryAmt": 3, "IsBuy": True}, {"Number": 3, "EntryPrice": 0, "EntryAmt": 2, "IsBuy": False}, {"Number": 4, "EntryPrice": 0, "EntryAmt": 1, "IsBuy": False}], "RealizedPNL": 0}
MagicDataList = MagicDataInfo["MagicDataList"]
# MagicDataList = [{"Number": 1, "EntryPrice": 0, "EntryAmt": 0, "IsBuy": True}, {"Number": 2, "EntryPrice": 0, "EntryAmt": 0, "IsBuy": True}, {"Number": 3, "EntryPrice": 0, "EntryAmt": 0, "IsBuy": True}, {"Number": 4, "EntryPrice": 0, "EntryAmt": 0, "IsBuy": False}]
stock_code = "TQQQ" 

stock_amt = 0

#현재 구간을 구할 수 있다.
find_step = DivNum
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
        
            print("매도처리 : ", SellAmt)
        find_step = div
        break

if IsOver == True:
    msg = stock_code + " 스마트스플릿 "+str(find_step)+"차 수익 매도 완료! 차수 목표수익률" + "% 만족 매도할 수량이 보유 수량보다 많은 상태라 모두 매도함!" 
        
    print(msg) 
                            
# print("현재 차수 : ", now_step) 