#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from collections import *

MOD = 1000000007
N = int(input())
nums = list(range(1,N+1))
d = defaultdict(int)
for i in range(1, N):
    ni = nums[i]
    if ni == 1:
        continue
    for j in range(i, N):
        while nums[j] % ni == 0:
            nums[j] //= ni
            d[ni] += 1
ans = 1
for v in d.values():
    ans = (ans * (v + 1)) % MOD
print(ans)
                
