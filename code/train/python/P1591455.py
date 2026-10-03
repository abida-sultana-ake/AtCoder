# -*- coding:utf-8 -*-
import math, sys
N = int(input())
x = 1
depth = math.floor(math.log(N, 2))
if depth == 0:
    print("Aoki")
    sys.exit()
for tmp in range(depth+1):
    if depth%2 == 0:
        if tmp%2 == 0:
            x = 2*x+1
        else:
            x *= 2
    else:
        if tmp%2 == 0:
            x *= 2
        else:
            x = 2*x+1
    if x > N:
        if tmp%2 == 0:
            print("Aoki")
            sys.exit()
        else:
            print("Takahashi")
            sys.exit()