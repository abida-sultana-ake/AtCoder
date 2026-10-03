import math
from decimal import *
N = int(input())
f = lambda: tuple(map(int, input().split()))
p = f()
for i in range(1, N):
    n = f()
    m = math.ceil(max(Decimal(p[0])/n[0], Decimal(p[1])/n[1]))
    p = (n[0]*m, n[1]*m)
print(sum(p))