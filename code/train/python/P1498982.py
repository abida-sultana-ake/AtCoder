# -*- coding:utf-8 -*-
import sys
N, M, A, B = map(int, input().split())
c = []
for tmp in range(M):
    c.append(int(input()))
for tmp in range(M):
    if A >= N:
        N += B
    N -= c[tmp]
    if N < 0:
        print(tmp+1)
        sys.exit()
print('complete')