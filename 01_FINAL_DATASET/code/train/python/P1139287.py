# -*- coding:utf-8 -*-
A = int(input())
ans = -1
for y in range(A+1):
    x=A-y
    ans = max(ans, x*y)
print(ans)