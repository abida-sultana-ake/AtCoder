# -*- coding: utf-8 -*-

#-------
# Initialize

N,T = map(int, input().split())
t = list(map(int, input().split()))
ans = T

#-------
# Do
for i in range(len(t)-1):
    ans += min(T, t[i+1] - t[i])

#-------
# Output
print(ans)
