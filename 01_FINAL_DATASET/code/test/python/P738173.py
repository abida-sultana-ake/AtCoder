#!/usr/bin/python3
from decimal import Decimal

D3_2 = Decimal('1.5')
D3 = Decimal('3')
f = lambda x: x + p / 2**(x/D3_2)

p = Decimal(input())
lo, hi = Decimal('0'), Decimal('1000')
for _ in range(100):
    m1 = (lo + lo + hi) / D3
    m2 = (lo + hi + hi) / D3
    if f(m1) < f(m2):
        hi = m2
    else:
        lo = m1
print(float(f(lo)))
