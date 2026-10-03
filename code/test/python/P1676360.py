#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
"""

# import {{{
from collections import ChainMap
from collections import Counter
from collections import defaultdict
from collections import deque
from collections import namedtuple
import bisect
import copy
import decimal
import fractions
import functools
import heapq
import itertools
import math
import operator
import pdb
import pprint
import random
import re
import string
import sys
import time

try:
    import numpy as np
    import scipy as sp
except:
    pass
# }}}

# util {{{
def is_odd(x):
    return x % 2 == 1

def is_even(x):
    return x % 2 == 0

def cmp(x, y):
    return (x > y) - (x < y)

def sgn(x):
    return cmp(x, 0)

def clamp(x, lo, hi):
    assert lo <= hi
    if x < lo:
        return lo
    elif x > hi:
        return hi
    else:
        return x

def chmax(xmax, x):
    if x > xmax:
        return x, True
    else:
        return xmax, False

def chmin(xmin, x):
    if x < xmin:
        return x, True
    else:
        return xmin, False

def argmax(seq):
    return max(range(len(seq)), key=seq.__getitem__)

def argmin(seq):
    return min(range(len(seq)), key=seq.__getitem__)

def INPUT():
    return input().rstrip() # CRLF対策

sys.setrecursionlimit(100000)
# }}}

# 適宜調整
PINF = float("inf")
NINF = float("-inf")
EPS  = 1e-9



def main():
    S = input()
    cnt = Counter(S)

    ok = all(is_even(v) for v in cnt.values())
    print("Yes" if ok else "No")

if __name__ == "__main__": main()
