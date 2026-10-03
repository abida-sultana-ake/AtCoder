from datetime import datetime
from datetime import timedelta
S = input()
y,m,d = int(S[:4]), int(S[5:7]), int(S[8:])
dt = datetime(y,m,d)
delta = timedelta(days=1)
while True:
    y,m,d = dt.year, dt.month, dt.day
    if y % (m*d) == 0:
        print("{0:04}/{1:02}/{2:02}".format(y,m,d))
        break
    dt = dt + delta
