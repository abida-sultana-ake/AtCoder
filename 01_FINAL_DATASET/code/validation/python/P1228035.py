# -*- coding:utf-8 -*-
import math
N = int(input())
A = list(map(int, input().split()))
ans = 0
for tmp in range(N):
    if A[tmp] != 0:
        ans += A[tmp]
ans /= N - A.count(0)
print(int(math.ceil(ans)))