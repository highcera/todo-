from datetime import datetime
import time

time_info = time.gmtime()

day_n = time_info.tm_mday
day_str = str(time_info.tm_mon) + "-" + str(time_info.tm_mday)

print(day_n, day_str)

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