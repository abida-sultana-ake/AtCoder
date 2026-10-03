# -*- coding: utf-8 -*-
import sys

N, K = map(int, input().split())
l = list(map(int, input().split()))

l.sort()
s = 0
for i in range(K):
    s += l[N-K+i]

print(s)