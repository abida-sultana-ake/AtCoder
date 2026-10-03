from fractions import gcd
from functools import reduce

def lcm(a, b):
    return a*b // gcd(a, b)

N = int(input())
T = []
for _ in range(N):
    T.append(int(input()))
print(reduce(lcm, T))