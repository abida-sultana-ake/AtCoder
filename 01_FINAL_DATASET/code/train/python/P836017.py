#! /usr/bin/env python3
s = []
for i in input():
    if i == 'B':
        s = s[:-1]
    else:
        s += [i]
print("".join(s))