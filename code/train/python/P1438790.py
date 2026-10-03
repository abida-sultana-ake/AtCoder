# -*- coding:utf-8 -*-
import sys
N = list(input())
R = list(reversed(N))
for tmp in range(len(N)):
    if N[tmp] != R[tmp]:
        print('NO')
        sys.exit()
print('YES')