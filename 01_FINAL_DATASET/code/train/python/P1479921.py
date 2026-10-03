#!/usr/bin
# -*- coding="utf-8" -*-
 
s = input()[:-1]
sn = len(s)

if sn % 2 == 1:
  sn = sn -1
for i in range(sn, 0, -2):
  if s[:i//2] == s[i//2:i]:
    break
print(len(s[:i]))