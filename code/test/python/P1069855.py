# -*- coding: utf-8 -*-
# problem C

N, K = map(int, input().split())
ls = list(map(int, input().split()))

ls_temp = ls[:K]
ans = sum(ls_temp)
x = sum(ls_temp)

for i in range(N - K):
    x = x - ls[i] + ls[K + i]
    ans += x 

print(ans)