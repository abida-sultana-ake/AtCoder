#!/usr/bin/env python3

import math

N = int(input())

a = N * N
b = (N+1) * (N+1)

s = math.floor(math.log10(N+1))

while (True):
    a0 = a // 10 ** (2*s)
    b0 = b // 10 ** (2*s)

    for c in range(a0, b0+1):
        d = c * (10 ** (2 * s))
        if (a <= d and d < b):
            print(c)
            exit()

    s -= 1
