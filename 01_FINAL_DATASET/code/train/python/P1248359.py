# -*- coding:utf-8 -*-
c = int(input())
ni = [list(map(int,input().split())) for _ in range(c)]
a,b,c = [float('-inf')]*3
for n in ni:
    n.sort()
    a = max(a,n[0])
    b = max(b,n[1])
    c = max(c,n[2])

print(a*b*c)
