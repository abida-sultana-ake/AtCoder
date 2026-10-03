#!/usr/bin/env python3
# -*- coding: utf-8 -*-
N = int(input())
N_orig = N
As = list(map(int,input().split()))
As.sort()

Bs = []
if N % 2 == 1:
    Bs.append(0)
    N -= 1
    b = 2
else:
    b = 1

while N > 0:
    Bs.append(b)
    Bs.append(b)
    N -= 2
    b += 2

if As != Bs:
    print(0)
else:
    print(pow(2, N_orig // 2, 1000000007))


