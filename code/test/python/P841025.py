#!/usr/bin/env python
# -*- coding:utf-8 -*-

from __future__ import division, print_function, absolute_import, unicode_literals

s = input()
isFound = False

for i, (a, b) in enumerate(zip(s[:-1], s[1:])):
    if a == b:
        isFound = True
        start, end = i+1, i+2
        break

for i, (a, b) in enumerate(zip(s[:-2], s[2:])):
    if a == b:
        isFound = True
        start, end = i+1, i+3
        break

if isFound is False:
    print("-1 -1")
else:
    print("{} {}".format(start, end))
