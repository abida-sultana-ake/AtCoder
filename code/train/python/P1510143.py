import math as m
from functools import reduce
n,T= int(input()),[]
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a
for i in range(n):
    T.append(int(input()))
tmp = max(T)
for i in range(n):
    if tmp % T[i] != 0:
        tmp = T[i]//gcd(tmp, T[i])*tmp

print(tmp)

