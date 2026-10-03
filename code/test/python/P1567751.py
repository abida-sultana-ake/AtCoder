N = int(input())
ss = N % 60
mm = (N // 60) % 60
hh = N // 3600
print("{0:02d}:{1:02d}:{2:02d}".format(hh, mm, ss))
