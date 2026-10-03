N = int(input())
ss = N % 60
N //= 60
mm = N % 60
N //= 60
hh = N % 60
if ss < 10:
    ss = '0' + str(ss)
else:
    ss = str(ss)
if mm < 10:
    mm = '0' + str(mm)
else:
    mm = str(mm)
if hh < 10:
    hh = '0' + str(hh)
else:
    hh = str(hh)
print(hh + ':' + mm + ':' + ss)


