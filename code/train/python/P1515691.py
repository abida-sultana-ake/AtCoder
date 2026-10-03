import math, itertools

def C(n,m):
    f = math.factorial
    return f(n) // (f(m) * f(n - m))

def DL(x,y):
    xy = x * y
    if xy < d + l:
        return 0
    return C(xy, d) * C(xy - d, l)
    
m = 10**9+7
r,c = map(int,input().split())
x,y = map(int,input().split())
d,l = map(int,input().split())
a = (r-x+1)*(c-y+1)
xy = x * y

if xy == d + l:
    b = C(xy, d) % m

else:
    b = 0
    p = itertools.product
    for us,ds,ls,rs in p([0,1], repeat=4):
        pt = DL(x - ls - rs, y - us - ds)
        if (us + ds + ls + rs) % 2 == 0:
            b += pt
        else:
            b -= pt
            
ans = a * b %m
print(ans)