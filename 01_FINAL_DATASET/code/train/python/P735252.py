from itertools import accumulate
from math import pi

def ints():
    return list(map(int, input().split()))

XMAX = 20001
n,q = ints()
xrh = (ints() for i in range(n))
ab = (ints() for i in range(q))

v = [0.0 for x in range(XMAX)]
def F(r,h,a,b):
    return (b*b*b - a*a*a) * pi * r * r / h / h / 3
for x,r,h in xrh:
    for dx in range(h):
        v[x + dx + 1] += F(r,h,h - (dx+1), h - dx)
V = list(accumulate(v))

for a,b in ab:
    print(V[b] - V[a])