# -*- coding:utf-8 -*-
l = [int(i) for i in input().split()]
if l[2] > l[1]+l[0]:
  print("dangerous")
elif l[2] > l[1]:
  print("safe")
else:
  print("delicious")