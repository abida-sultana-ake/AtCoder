from math import pi
n = int(input())
r = sorted([int(input()) for _ in range(n)], reverse=True)
f = 1
ret = 0
for i in r:
    ret += i**2 * f
    f *= -1
print(ret*pi)
