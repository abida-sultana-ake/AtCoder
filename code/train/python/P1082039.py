#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from collections import *
n = int(input())
As = list(map(int,input().split()))

d = Counter()
for a in As:
    d[a] += 1

two = 0
num = 0
for k,v in d.items():
    if v == 1:
        continue
    elif v % 2 == 0:
        two += 1
        num += v // 2 - 1
    else:
        num += v // 2

num += (two + 1) // 2

print(n - (num * 2))
