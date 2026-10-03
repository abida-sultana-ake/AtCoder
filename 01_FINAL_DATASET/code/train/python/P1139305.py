# -*- coding:utf-8 -*-
import math
N = int(input())
R = []
ans = 0
for tmp in range(N):
    R.append(int(input()))
R = sorted(R)
factor, flag = (N - 1, 1)
while factor >= 0:
    if flag:
        ans += (R[factor]**2)*math.pi
        flag = 0
    else:
        ans -= (R[factor]**2)*math.pi
        flag = 1
    factor -= 1
print(ans)