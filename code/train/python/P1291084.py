# -*- coding: utf-8 -*-

N = int(input())
sum = 0
for i in range(1,N+1):
    sum += i*10000
ave = sum*1/N
print(int(ave))
