n,d=map(int,input().split())
x,y=map(int,input().split())
x=abs(x)
y=abs(y)

if (x%d!=0 or y%d!=0) or ((x//d+y//d)&1 != n&1) or (x//d+y//d>n):
    print(0.0)
    exit(0)
ans = 0

from functools import *
def c(n, k):
    if k == 0: return 1
    return reduce(lambda x,y:x*y, range(n-k+1, n+1)) // reduce(lambda x,y:x*y, range(1, k+1))

ans = 0
for i in range(0, n-(x//d+y//d)+1, 2):
    ans += c(n, x//d+i) * c(x//d+i, i//2) * c(n-x//d-i, (n-x//d-i-y//d)//2)
print("%.12f" % (ans/(4**n)))
