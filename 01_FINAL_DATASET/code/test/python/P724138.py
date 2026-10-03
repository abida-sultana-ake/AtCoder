# -*- coding:utf-8 -*-
N, K = map(int, input().split())
a = list(map(int, input().split()))
x = N-K+1
ans = sum(a)*x

for y in range(N-K):
    ans -= a[y]*(x-y-1)
    ans -= a[-(y+1)]*(x-y-1)

print(ans)