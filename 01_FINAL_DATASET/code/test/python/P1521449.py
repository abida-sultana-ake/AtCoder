N = int(input())
h = N // 3600
m = (N % 3600) // 60
s = N % 60
print('{0:02d}:{1:02d}:{2:02d}'.format(h,m,s))
