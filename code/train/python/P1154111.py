from datetime import datetime, timedelta

l= input()
dt = datetime.strptime(l, '%Y/%m/%d');

while True:
    if dt.year % (dt.month*dt.day) == 0:
        print(dt.strftime('%Y/%m/%d'))
        break
    dt += timedelta(days=1)
