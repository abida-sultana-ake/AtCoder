# -*- coding:utf-8 -*-
N = int(input())
s = N%60
t = N//3600
m = N//60 - 60*t
print("%02d:%02d:%02d" %(t,m,s))