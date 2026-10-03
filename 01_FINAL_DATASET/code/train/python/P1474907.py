#!/usr/bin
# -*- coding="utf-8" -*-
 
K = int(input())
if K >= 50:
  N = 50
  a = K % N
  if a == 0:
    n = [K // N + 49] * N
  else:
    n = [K // N + (49 - a)] * N
    for i in range(a):
      n[i] = n[i] + N
elif K == 0:
  N = 2
  n = ["1", "1"]
else:
  N = K + 1
  n = [0] * N
  n[0] = K**2 + K*2
n = ' '.join(list(map(str, n)))
print(N)
print(n)