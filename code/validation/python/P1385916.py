# -*- coding: utf-8 -*-

d = 10**9 + 7
n, m = map(int, input().split(' '))

ans = 0

ans1 = 1
n1 = n
m1 = m
while n1 >= 1:
    ans1 *= n1 * m1
    ans1 %= d
    n1 -= 1
    m1 -= 1

if m1 > 1:
    ans1 = 0

ans2 = 1
n2 = n
m2 = m
while m2 >= 1:
    ans2 *= m2 * n2
    ans2 %= d
    n2 -= 1
    m2 -= 1

if n2 > 1:
    ans2 = 0


print((ans1 + ans2) % d)
