# -*- coding: utf-8 -*-
n = input()
a = map(int,raw_input().split())

dp = [0]*n
dp[1] = abs(a[1]-a[0])
for i in range(2,n):
    dp[i] = min(dp[i-2]+abs(a[i]-a[i-2]),dp[i-1]+abs(a[i]-a[i-1]))
print(dp[n-1])
    