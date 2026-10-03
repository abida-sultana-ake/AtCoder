#!/usr/bin/env python3
# -*- coding: utf-8 -*-

K = int(input())

a,b = 1,1
k = 1
while k < K:
    a,b = b, a+b
    k += 1
print(a,b)
