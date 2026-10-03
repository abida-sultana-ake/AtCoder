# -*- coding:utf-8 -*-
import math
y, m, d = (int(input()), int(input()), int(input()))
Y, M, D = (2014, 5, 17)
a = 365*Y+math.floor(Y/4)-math.floor(Y/100)+math.floor(Y/400)+math.floor((306*(M+1))/10)+D-429
if m == 1 or m == 2:
    m += 12
    y -= 1
b = 365*y+math.floor(y/4)-math.floor(y/100)+math.floor(y/400)+math.floor((306*(m+1))/10)+d-429
print(a-b)