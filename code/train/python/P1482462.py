# -*- coding:utf-8 -*-
import math, itertools
N = int(input())
a = []
maximum = float('-inf')
for tmp in range(N):
    x,y = map(int, input().split())
    a.append((x,y))
b = list(itertools.combinations(a,2))
for tmp in b:
    factor = (tmp[0][0]-tmp[1][0])**2 + (tmp[0][1]-tmp[1][1])**2
    maximum = max(maximum, math.sqrt(factor))
print(maximum)