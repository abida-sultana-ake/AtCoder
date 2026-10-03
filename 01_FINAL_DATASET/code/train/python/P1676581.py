# 二分法
import math

def ft(_t):
    return a * _t + b * math.sin(c*_t*math.pi) - 100

a, b, c = (int(i) for i in input().split())

hidari = 0
migi = 200

ft_now = 1

while abs(ft_now) > 0.000001:
    t = (hidari + migi) / 2
    ft_now = ft(t)
    if ft_now < 0:
        hidari = t
    else:
        migi = t
print(t)
