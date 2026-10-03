#!/usr/bin/env python3
# -*- coding: utf-8 -*-

mod = 1000000007
A, B, C = (int(input()) for _ in range(3))

r = (B*C - A*C) * pow(A*B - B*C + A*C, mod - 2, mod) % mod
c = (B*C - A*B) * pow(A*C - B*C + A*B, mod - 2, mod) % mod
print('{} {}'.format(r, c))
