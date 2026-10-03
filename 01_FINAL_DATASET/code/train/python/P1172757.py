# -*- coding:utf-8 -*-
n,m,a,b = map(int,input().split())
output = "complete"
for i in range(m):
    c = int(input())
    if i == 0 and n <= a:
        n += b
    n -= c
    if n < 0:
        output = int(i+1)
        break
    if n <= a:
        n += b
print(output)
