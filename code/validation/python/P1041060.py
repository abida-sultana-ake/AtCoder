# -*- coding: utf-8 -*-
# problem A

N = int(input())

ans = 0
for i in range(N+1):
    ans += i
print(ans)