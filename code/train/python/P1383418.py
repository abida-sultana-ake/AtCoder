# -*- coding:utf-8 -*-
import sys
N = int(input())
a = [ int(input()) for tmp in range(N) ]
ans = 0
index = 0
while ans < len(a):
    sav = index #last index
    index = a[sav]-1 #new index
    ans += 1
    if index == 1:
        print(ans)
        sys.exit()
    if a[index] == sav+1: #Loop
        print("-1")
        sys.exit()
print("-1")