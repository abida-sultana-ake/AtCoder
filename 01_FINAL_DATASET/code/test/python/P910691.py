# -*- coding: utf-8 -*-
n, x = map(int, input().split())

l = n - x
r = x - 1

print(l if l < r else r)