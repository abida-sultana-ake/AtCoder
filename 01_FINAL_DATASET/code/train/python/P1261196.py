# -*- coding: utf-8 -*-
n,k = map(int,raw_input().split())
d = map(int,raw_input().split())
flg = 1
num = n-1
while(flg):
    num += 1
    strnum = str(num)
    check = [strnum.find(str(i))+1 for i in d]
    flg = sum(check)
print(num)