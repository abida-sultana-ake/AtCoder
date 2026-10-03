from math import sin,pi

def f(a,b,c,t):
    return a * t + b * sin(c * t * pi)

eps = 10**-7
a,b,c = map(int,input().split())
lo = 0.0
hi = 200.0
t = (lo+hi)/2
ft = f(a,b,c,t)
while abs(ft - 100) > eps:
    if ft > 100:
        hi = t
    else:
        lo = t
    t = (lo+hi)/2
    ft = f(a,b,c,t)
print(t)