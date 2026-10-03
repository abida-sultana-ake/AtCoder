# -*- coding: utf-8 -*-

import math

x1, y1, r = map(int, input().split())
x2, y2, x3, y3 = map(int, input().split())

d1 = math.hypot(x1 - x2, y1 - y2) <= r
d2 = math.hypot(x1 - x3, y1 - y2) <= r
d3 = math.hypot(x1 - x3, y1 - y3) <= r
d4 = math.hypot(x1 - x2, y1 - y3) <= r

# circle in rectangle
if (x2 + r <= x1 <= x3 - r) and (y2 + r <= y1 <= y3 - r):
    print("NO")
else:
    print("YES")

# rectangle in circle
if d1 and d2 and d3 and d4:
    print("NO")
else:
    print("YES")