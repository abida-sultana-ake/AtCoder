#!/usr/bin/env python3
# -*- coding: utf-8 -*-

P = float(input())
def f(x):
    return x + P / (2 ** (x / 1.5))

a = 0
b = 1000
for _ in range(10000):
    left = (a+a+b) / 3
    right = (a+b+b) / 3
    fl = f(left)
    fr = f(right)
    if fl < fr:
        b = right
    else:
        a = left

mn = max(0, (a+b)/2)
print("{:.15f}".format(f(mn)))
