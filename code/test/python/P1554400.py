n = int(input())
hh = n // 3600
mm = (n % 3600) // 60
ss = (n % 3600) % 60
print("%02d"%hh + ":" + "%02d"%mm + ":" + "%02d"%ss)