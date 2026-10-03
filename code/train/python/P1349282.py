# -*- coding: utf-8 -*-
import sys

N = input()
an = input()
s = sorted(set(map(int, an.split())))
print(s[-1] - s[0])
