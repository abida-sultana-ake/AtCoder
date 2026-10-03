# -*- coding:utf-8 -*-
N = int(input())
point = []
for tmp in range(N):
    a,b,c,d,e = map(int, input().split())
    point.append(a+b+c+d+110/900*e)
print(sorted(point)[len(point)-1])