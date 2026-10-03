# -*- coding: utf-8 -*-

n = int(input())
l = list(map(int, input().split()))

s = 0
a = sum(l)
ans = float('inf')

for i in range(0, n-1):
    s += l[i]
    a -= l[i]
    ans = min(ans, abs(s-a))

print(ans)
