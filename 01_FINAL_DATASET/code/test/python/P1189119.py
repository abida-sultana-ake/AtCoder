# -*- coding: utf-8 -*-
import math
N, A, B = map(int, input().split())
V = list(map(int, input().split()))
V.sort(reverse=True)
maxavg = sum(V[:A])/A
print(maxavg)
min = V[A-1]
ltAnum = 0
minnum = 0
for i in range(N):
    if V[i] > min:
        ltAnum = ltAnum + 1
    elif V[i] == min:
        minnum = minnum + 1
    else:
        break
#print(ltAnum)
#print(minnum)

import math
def nCr(n,r):
    f = math.factorial
    return f(n)//f(r)//f(n-r)

c_min = 0
import itertools
if ltAnum > 0:
    c_min = nCr(minnum, A-ltAnum)
if ltAnum == 0:
    for j in range(A, B+1):
        if minnum < j:
            break
        else:
            c_min = c_min + nCr(minnum, j)
print(c_min)
