#!/usr/bin/env python3
n, x = map(int, input().split())
a = list(map(int, input().split()))
ans = 0
for i in range(n-1):
    delta = max(0, a[i] + a[i+1] - x)
    a[i+1] -= delta
    if a[i+1] < 0:
        a[i] += a[i+1]
        a[i+1] = 0
    ans += delta
print(ans)
