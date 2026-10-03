from datetime import date
from datetime import timedelta
import datetime

tmp = input()
tmp2 = []
today_date = []
flag = True

tmp2 = tmp.split('/')

for i in range(3):
    today_date.append(int(tmp2[i]))

now_day = date(today_date[0],today_date[1],today_date[2])
one_day = timedelta(days = 1)

while(flag == True):
    
    if((now_day.year % (now_day.month * now_day.day)) == 0):
        print("%4d" % now_day.year +'/'+"%02d" % now_day.month +'/'+"%02d" % now_day.day)
        flag = False
    else:
        now_day = now_day + one_day
    

