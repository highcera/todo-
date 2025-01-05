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

# DivNum = 4
# MagicDataInfo = {"StockCode": "TQQQ", "IsReady": True, "MagicDataList": [{"Number": 1, "EntryPrice": 0, "EntryAmt": 4, "IsBuy": True}, {"Number": 2, "EntryPrice": 0, "EntryAmt": 3, "IsBuy": True}, {"Number": 3, "EntryPrice": 0, "EntryAmt": 2, "IsBuy": False}, {"Number": 4, "EntryPrice": 0, "EntryAmt": 1, "IsBuy": False}], "RealizedPNL": 0}
# MagicDataList = MagicDataInfo["MagicDataList"]
# # MagicDataList = [{"Number": 1, "EntryPrice": 0, "EntryAmt": 0, "IsBuy": True}, {"Number": 2, "EntryPrice": 0, "EntryAmt": 0, "IsBuy": True}, {"Number": 3, "EntryPrice": 0, "EntryAmt": 0, "IsBuy": True}, {"Number": 4, "EntryPrice": 0, "EntryAmt": 0, "IsBuy": False}]
# stock_code = "TQQQ" 

# stock_amt = 0

# #현재 구간을 구할 수 있다.
# find_step = DivNum
# IsOver = False

# for div in range(int(DivNum), 0, -1):
#     # print(div, MagicDataList[div-1]["IsBuy"])
#     if MagicDataList[div-1]["IsBuy"] == True:
#         if div != 1 and div != 2:
#             SellAmt = MagicDataList[div-1]["EntryAmt"]
#             print(SellAmt)
            
#             #만약 매도할 수량이 수동 매도등에 의해서 보유 수량보다 크다면 보유수량으로 정정해준다!
#             if SellAmt > stock_amt:
#                 SellAmt = stock_amt
#                 IsOver = True
        
#             print("매도처리 : ", SellAmt)
#         find_step = div
#         break

# if IsOver == True:
#     msg = stock_code + " 스마트스플릿 "+str(find_step)+"차 수익 매도 완료! 차수 목표수익률" + "% 만족 매도할 수량이 보유 수량보다 많은 상태라 모두 매도함!" 
        
#     print(msg) 
                            
# print("현재 차수 : ", now_step) 

import pandas as pd

path = "D:/F 드라이브/Java_tutor/todo-/todo-/Exam/src/Udemic/게만아/"

'''

# df = pd.read_csv(path + "combined_df.csv")
# print(df)

# origin = df[['Date', 'open', 'high', 'low', 'close', 'volume', 'stock_code']]
# print(origin)

# origin.to_csv(path + "origin.csv", index=False)

df = pd.read_csv(path + "origin.csv", index_col='Date')
# df = pd.read_csv(path + "origin.csv")
print(df)

temp = df.loc[df['stock_code'] == 133690]
print(temp)

stock_list = [133690, 132030, 69500, 305080, 148070]
sep_data_list = list()

for stock in stock_list:
    sep_data = dict()
    
    temp = df.loc[df['stock_code'] == stock]
    data = temp[['open', 'high', 'low', 'close', 'volume']]
    
    data.to_csv(path + "sepa_" + str(stock) + ".csv")
    
    sep_data['stock_code'] = stock
    sep_data['data'] = data
    print(sep_data)
   
    sep_data_list.append(sep_data)

print(sep_data_list)
'''




# ==========================================================================================================================================


stock_df_list = []

# for stock_code in StockCodeList:
# df = Common.GetOhlcv("KR", stock_code,300) 
df = pd.read_csv(path + "sepa_69500.csv", index_col="Date")
print(df)

 #거래량과 시가,종가,저가,고가의 평균을 곱해 대략의 거래대금을 구해서 value 라는 항목에 넣는다 ㅎ
df.insert(5,'value',((df['open'] + df['high'] + df['low'] + df['close'])/4.0) * df['volume'])
df.insert(6,'change',(df['close'] - df['close'].shift(1)) / df['close'].shift(1))

df[[ 'open', 'high', 'low', 'close', 'volume', 'change']] = df[[ 'open', 'high', 'low', 'close', 'volume', 'change']].apply(pd.to_numeric)
print(df)




df['prevClose'] = df['close'].shift(1)
df['prevClose2'] = df['close'].shift(2)    
print(df)

df['ma_Before2'] = df['close'].rolling(20).mean().shift(3) 
df['ma_Before'] = df['close'].rolling(20).mean().shift(2) 
df['ma'] = df['close'].rolling(20).mean().shift(1) 
print(df)

df['change_ma'] = df['change'].rolling(20).mean().shift(1) #20일 등락률의 평균

df.dropna(inplace=True) #데이터 없는건 날린다!
# data_dict = {stock_code: df}
# stock_df_list.append(data_dict)
    
print("len : ",len(df))    
print(df)
    
# combined_df = pd.concat([list(data_dict.values())[0].assign(stock_code=stock_code) for data_dict in stock_df_list for stock_code in data_dict])
# combined_df.sort_index(inplace=True)
# pprint.pprint(combined_df)
# print(" len(combined_df) ", len(combined_df))

date = df.iloc[-1].name
print(date)
# Top_stocks = combined_df.loc[combined_df.index == date].groupby('stock_code')['change_ma'].max().nlargest(1)