#! /usr/bin/env python3

c = w = l = 0
for i in input():
    if c == 0:
        c += 1
        if i == 'p':l += 1
    else:
        c -= 1
        if i == 'g' : w += 1
print(w-l)