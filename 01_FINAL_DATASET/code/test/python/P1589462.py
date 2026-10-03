# -*- coding:utf-8 -*-
import itertools
N = int(input())
t = [ int(input()) for _ in range(N) ]
minimum = float("inf")
for factors in itertools.product([True, False], repeat=N):
    b, c = (0, 0)
    for tmp in range(len(factors)):
        if factors[tmp]:
            b += t[tmp]
        else:
            c += t[tmp]
    minimum = min(minimum, max(b,c))
print(minimum)