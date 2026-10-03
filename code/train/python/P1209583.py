#!/usr/bin/env python3
import string
n = int(input())
f = [ float('inf') ] * 26
for _ in range(n):
    s = input()
    for i, c in enumerate(string.ascii_lowercase):
        f[i] = min(f[i], s.count(c))
for i, c in enumerate(string.ascii_lowercase):
    print(c * f[i], end='')
print()
