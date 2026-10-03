# -*- coding: utf-8 -*-

import sys
import os

N = int(input())
s = input().strip()
t = s

while '()' in t:
    t = t.replace('()', '')

left = t.count('(')
right = t.count(')')

answer = '(' * right + s + ')' * left

print(answer)