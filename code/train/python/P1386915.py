# -*- coding:utf-8 -*-
import math
N, H = map(int, input().split())
A, B, C, D, E = map(int, input().split())
consume = N*E
a = H - consume
b = B + E
c = D + E
if a > 0:
    print(0)
else:
    flag1 = 0
    flag2 = 0
    if abs(a)%b == 0:
        flag1 = 1
    if abs(a)%c == 0:
        flag2 = 1
    ans = min(A*(math.ceil(abs(a)/b)+flag1), C*(math.ceil(abs(a)/c)+flag2))
    for tmp in range(abs(a)//c+1):
        factor = math.ceil((abs(a)-c*tmp)/b)
        if c*tmp+b*factor+a > 0:
            ans = min(ans, C*tmp+A*factor)
    print(ans)