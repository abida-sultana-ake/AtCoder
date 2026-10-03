import datetime
y,m,d=[int(input())for _ in [0]*3]
print((datetime.date(2014,5,17)-datetime.date(y,m,d)).days)