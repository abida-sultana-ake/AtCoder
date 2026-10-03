#!/usr/bin/env python
# -*- coding: utf-8 -*-

L,X,Y,S,D = map(int,input().split())

if S < D:
    ans = (D - S)/(Y+X)
    if Y-X > 0:
        ans = min(ans, (L+S-D)/(1 if Y-X <= 0 else Y-X))
else:
    ans = (L+D-S)/(X+Y)
    if Y-X > 0:
        ans = min(ans, (S - D)/(1 if Y-X <= 0 else Y-X))
print("%.7f" %ans)
