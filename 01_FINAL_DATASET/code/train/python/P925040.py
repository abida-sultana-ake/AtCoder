import sys
sys.setrecursionlimit(10000000)
n = int(input())
a = list(map(int, input().split()))
tb = [0 for i in range(n)]
tb[1]=abs(a[1]-a[0])
for i in range(2,n):
    tb[i] = min(tb[i-1]+abs(a[i]-a[i-1]),tb[i-2]+abs(a[i]-a[i-2]))
print(tb[n-1])