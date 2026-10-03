# -*- coding:utf-8 -*-
import sys
N, T = map(int, input().split())
A = [ int(input()) for tmp in range(N) ]
index, ans = (0, 0)
while index < N-1:
    s = A[index+1] - A[index]
    if s > T:
        ans += T
    else:
        ans += s
    index += 1
print(ans+T)