# -*- coding:utf-8 -*-
m,n,sell = map(int,input().split())

z = 0
total = 0
while True:
    total += sell
    if sell+z < m:
        break
    tmpsell = int((sell+z)/m)*n
    z = (sell+z)%m
    sell = tmpsell

print(total)
