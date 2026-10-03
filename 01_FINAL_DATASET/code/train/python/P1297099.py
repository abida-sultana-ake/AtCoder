# -*- coding: utf-8 -*-
import sys,math

H,W = map(int,input().split(" "))

def calc(a,b,c):
    tmp = (a[0]*a[1],b[0]*b[1],c[0]*c[1])
    return max(tmp) - min(tmp)

result = H*W

#H
for i in range(H//2+1):
    a = (i,W)
    hh = H-i
    rest = (hh,W)

    result = min([result,calc(a,(hh//2,W),(hh-hh//2,W)),calc(a,(hh,W//2),(hh,W-W//2))])

#W
for i in range(W//2+1):
    a = (H,i)
    ww = W-i
    rest = (H,ww)

    result = min([result,calc(a,(H//2,ww),(H-H//2,ww)),calc(a,(H,ww//2),(H,ww-ww//2))])

print(result)
