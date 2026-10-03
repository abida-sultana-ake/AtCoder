from math import sqrt
n = int(input())
s = int(input())

if n < s:
  print(-1)
  import sys
  sys.exit()
if n == s:
  print(n+1)
  import sys
  sys.exit()

def f(b, n):
  if n < b:
    return n
  return f(b, n//b) + (n % b)

res = -1

for p in range(int(sqrt(n)), 0, -1):
  b = (n-s)//p + 1
  if b == 1:
    continue
  if f(b, n) == s:
    res = b
    break

for b in range(2, int(sqrt(n))+2):
  if f(b, n) == s:
    res = b
    break

print(res)