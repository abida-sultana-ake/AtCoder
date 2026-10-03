# -*- coding: utf-8 -*-
# problem A

a, b, c, d = map(int, input().split())
s1 = a * b
s2 = c * d

print(max(s1, s2))