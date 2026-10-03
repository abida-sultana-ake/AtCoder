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
    N = int(input())
    print("ABC{:03d}".format(N))

if __name__ == "__main__": main()
