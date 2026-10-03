#!/usr/bin
# -*- cording: "utf-8" -*-
 
a, b = map(int, input().split())
c = list(map(int, input().split()))
c.sort(reverse=True)
x = 0
for i in range(b):
  x = x + c[i]
print(x)