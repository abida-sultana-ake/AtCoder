#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import sys
import re
import math
import collections
import itertools
import functools

DEBUG = True
DEBUG = False

def dbg(*args):
    if DEBUG:
        print("DBG: ", file=sys.stderr, end="")
        print(*args, file=sys.stderr)



def main():
    n, k = map(int, input().split())
    ls = list(map(int, input().split()))

    ls.sort(reverse=True)
    ans = sum(ls[:k])
    print(ans)

if __name__ == "__main__": main()
