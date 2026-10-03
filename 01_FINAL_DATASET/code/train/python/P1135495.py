import math
a,b,c=map(int,input().split())
def f(t):
    return a*t+b*math.sin(c*t*math.pi)

mt = 100/a
lt = (100-b)/a
rt = (100+b)/a
for _ in range(10000):
    mt = (lt+rt)/2
    if abs(f(mt)-100) <= 10**-6:
        break
    if f(mt)-100 > 0:
        rt = mt
    else:
        lt = mt

print(mt)