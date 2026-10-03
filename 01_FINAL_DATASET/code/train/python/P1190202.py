# -*- coding:utf-8 -*-
N = int(input())
ans = 0
for i in range(1, N+1):
    ans += i * 10000
print(int(ans/N))