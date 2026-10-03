# -*- coding: utf-8 -*-
 
n,t = map(int, raw_input().split())
a = map(int, raw_input().split()) 
 
m = 10**9+1
num = 0
diff = 0
for i in range(n):
    if(a[i]<m):
        m = a[i]
    if(a[i]-m > diff):
        diff = a[i]-m
        num = 1
    elif(a[i]-m == diff):
        num += 1
print(num)