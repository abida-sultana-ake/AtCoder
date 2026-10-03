# -*- coding:utf-8 -*-
x, y = map(int, input().split())
k = int(input())
if y-k >= 0:
    print(x+k)
else:
    print(y+x-abs(y-k))