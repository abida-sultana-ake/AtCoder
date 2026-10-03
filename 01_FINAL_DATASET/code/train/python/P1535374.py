MOD = 10**9+7

N = int(input())

X = input()
input()

from itertools import chain

d = {(2,2):3, (1,2):1, (2,1):2, (1,1):2, (2,0):6, (1,0):3, (0,0):1}

r = 1
p = 0
n = 0
l = None
for x in chain(X,(None,)):
  if x == l:
    n += 1
  else:
    l = x
    r *= d[(n,p)]
    r %= MOD
    p = n
    n = 1

print(r)