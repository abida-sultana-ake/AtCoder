#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import functools

@functools.lru_cache(maxsize = None)
def simulate(x, y):
    """ return True means first player wins """
    # print("simulate ", x, y)
    if x <= 1 and y <= 1:
        return False
    for i in range(1, x // 2):
        tmp = simulate(x - i * 2, y + i)
        if tmp == False:
            return True
    for i in range(1, y // 2):
        tmp = simulate(x + i, y - i * 2)
        if tmp == False:
            return True
    return False

# size = 100
# for x in range(size):
#     for y in range(size):
#         print(int(simulate(x, y)), end = " ")
#     print("")


def fast(X, Y):
    if X <= 2:
        if Y <= 3:
            return False
        else:
            return True
    elif X == 3:
        if Y <= 4:
            return False
        else:
            return True
    else:
        if X - 1 <= Y <= X + 1:
            return False
        else:
            return True

X, Y = map(int, input().split())
X, Y = min(X, Y), max(X, Y)
if fast(X, Y):
    print("Alice")
else:
    print("Brown")
