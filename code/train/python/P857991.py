from sys import exit
from itertools import product

def read():
  return int(input())

def reads():
  return [int(x) for x in input().split()]

def primes(n):
    numbers = set(range(n, 1, -1))
    primes = []
    while numbers:
        p = numbers.pop()
        primes.append(p)
        numbers.difference_update(set(range(p*2, n+1, p)))
    return sorted(primes)

PRIMES = primes(10**6)

def pfact(x):
  res = dict()
  while x > 1:
    for p in PRIMES:
      if p >= x**0.5 + 1:
        res[x] = res.get(x, 0) + 1
        x = 1
        break
      if x % p == 0:
        res[p] = res.get(p, 0) + 1
        x //= p
        break
  return res

def prod(xs):
  res = 1
  for x in xs:
    res *= x
  return res

def divisors(n):
  P = list(pfact(n).items())
  res = []
  for ds in product(*[range(e+1) for (p, e) in P]):
    res.append(prod(P[i][0]**ds[i] for i in range(len(P))))
  return sorted(res)

def f(b, n):
  return 0 if n == 0 else f(b, n//b) + n % b

n = read()
s = read()

if n < s:
  print(-1); exit()

if n == s:
  print(s+1); exit()

for x in divisors(abs(n-s)):
  b = x + 1
  if f(b, n) == s:
    print(b); exit()

print(-1)
