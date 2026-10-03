# -*- coding: utf-8 -*-
import numpy as np

r, c, d = (int(_) for _ in input().split())
a = [[int(_) for _ in input().split()] for _ in range(r)]

maxNum = 0
for i in range(r):
    for j in range(c):
        if i + j > d:
            break
        if (i + j) % 2 == d % 2:
            if maxNum < a[i][j]:
                maxNum = a[i][j]

print(maxNum)