from sys import exit, setrecursionlimit
from functools import reduce
from itertools import *
from collections import defaultdict
from bisect import bisect

def read():
  return int(input())

def reads():
  return [int(x) for x in input().split()]

setrecursionlimit(1000000)

N = read()
a = reads()

b = [(-a[i], i) for i in range(N)]
b.sort()
b.append((0, -1))
# print(b)

result = [0] * N

m = b[0][1]
j = 0
for i in range(1, N+1):
  if b[j][0] != b[i][0]:
    # print(j, i, (b[i][0] - b[j][0]))
    result[m] += (b[i][0] - b[j][0]) * i
    j = i
  m = min(m, b[i][1])

# print(" ".join(str(k) for k in result))
for i in range(N):
  print(result[i])
