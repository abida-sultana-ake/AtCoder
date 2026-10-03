#! -*- coding:utf-8 -*-
def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a
 
def lcm(a, b):
    return a * b // gcd(a, b)

n = int(input())
k = []
for i in range(n):
    k.append(int(input()))

if n == 1:
    print(k[0])
else:
    p = lcm(k[0],k[1])
    for i in range(n):
        p = lcm(p,k[i])
    print(int(p))
