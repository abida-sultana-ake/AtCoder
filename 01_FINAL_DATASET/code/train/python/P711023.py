# -*- coding: utf-8 -*-
from collections import Counter

S = list(input())
T = int(input())

c = Counter(S)
x = -c.get("L", 0) + c.get("R", 0)
y = -c.get("D", 0) + c.get("U", 0)
unknown = c.get("?", 0)
if T == 1:
    print(abs(x) + abs(y) + unknown)
else:
    if abs(x) + abs(y) >= unknown:
        print(abs(abs(x) + abs(y) - unknown))
    else:
        print(0 if abs(abs(x) + abs(y) - unknown) % 2 == 0 else 1)