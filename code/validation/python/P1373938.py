from math import factorial
n, m = [int(i) for i in input().split()]
const = 10**9 + 7
nf = factorial(n) % const
mf = factorial(m) % const
ret = (nf * mf) % const
if n - m == 1 or m - n == 1:
    ret = (nf * mf) % const
elif n == m:
    ret *= 2
    ret %= const
else:
    ret = 0
print(ret)