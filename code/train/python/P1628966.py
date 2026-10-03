# -*- coding:utf-8 -*-
import math
x1, y1, r = map(int, input().split())
x2, y2, x3, y3 = map(int, input().split())
flag1, flag2 = (False, False)
#circle in square
if x1-r >= x2 and x1+r <= x3 and y1+r <= y3 and y1-r >= y2:
    flag1 = True

#square not in circle?
square = [ (x2,y2), (x2,y3), (x3,y2), (x3, y3) ]
for tmp in square:
    if math.sqrt((tmp[0]-x1)**2+(tmp[1]-y1)**2) > r:
        flag2 = True
        break

if flag1:
    print("NO")
else:
    print("YES")

if flag2:
    print("YES")
else:
    print("NO")