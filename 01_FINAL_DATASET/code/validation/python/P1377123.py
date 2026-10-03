import math
max = 1000000007
def test(x):
  return x if x<max else (x % max)

def kai(m):
  if m == 1:
    return 1
  else:
    return test(kai(m-1) * m)

n,m = map(int,input().split())
ret = 0
if n == m:
  k = math.factorial(m)
  ret = test(2 * k * k)
elif n-m == 1:
  k = math.factorial(m)
  ret = test(k * k * n)
elif n-m == -1:
  k = math.factorial(n)
  ret = test(k * k * m)
print(ret)