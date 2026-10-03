# -*- coding:utf-8 -*-
l = list(map(int,input().split()))
f = list(set(l))
if l.count(f[0]) == 1 or len(f) == 1:
    print(f[0])
else:
    print(f[1])