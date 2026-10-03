n = int(input())
a=[int(i) for i in input().split()]
sum=0
for i in range(0,n):
    sum += a[i]
x = [a[0]]*n
xy = [None]*(n-1)
for i in range(1,n):
    x[i] = x[i-1]+a[i]
for i in range(0,n-1):
    xy[i] = abs(sum - 2*x[i])
print(min(xy))
