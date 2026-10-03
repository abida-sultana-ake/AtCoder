import sys
sx,sy = [int(i) for i in input().split()]
x = [int(i) for i in input().split()]
y = [int(i) for i in input().split()]
ax = 0
ay = 0
# #test
# sx = 8のとき
# 1 1 1 1 1 1 1
# 1 2 2 2 2 2 1
# 1 2 3 3 3 2 1
# 1 2 3 4 3 2 1
# 1 2 3 3 3 2 1
# 1 2 2 2 2 2 1
# 1 1 1 1 1 1 1
# (x[1]-x[0])*sx
# (x[2]-x[1])*sx+sx-2
# (x[3]-x[2])*sx+sx-2+sx-4
# (x[n+1]-x[n])*(sx+sx-2*n)*(n+1)/2
# sxが奇数の時
for n in range(sx-1):
	ax += (x[n+1]-x[n])*(sx-n-1)*(n+1)
for n in range(sy-1):
	ay += (y[n+1]-y[n])*(sy-n-1)*(n+1)
print(ax*ay%(10**9+7))