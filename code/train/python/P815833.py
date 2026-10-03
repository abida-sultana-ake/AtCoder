# coding: utf-8

from __future__ import print_function
from __future__ import unicode_literals
from __future__ import division
from __future__ import absolute_import
import math
import string
import itertools
import fractions
import heapq
import collections
import re
import array
import bisect

def array2d(d1, d2, init = None):
    return [[init for _ in range(d2)] for _ in range(d1)]

N, K = map(int, input().split(" "))
ds = list(map(int, input().split(" ")))
cs = []
for i in range(10):
    if i not in ds: cs.append(i)

ns = str(N)


def solve(N, digit):
    if digit == -1:
        return N
    n = int((N // (10**digit)) % 10)
    if n not in ds:
        return solve(N, digit - 1)
    else:
        new_N = N // (10**(digit + 1))
        new_N = new_N * (10**(digit + 1))
        for i in range(n + 1, 10):
            if i not in ds:
                new_N = new_N + (10**digit) * i
                return solve(new_N, digit-1)
        else:
            new_N = new_N + 10**(digit + 1)
            return solve(new_N, len(str(new_N))-1)

print(solve(N, len(str(N))-1))
