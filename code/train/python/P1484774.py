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
    s = input()
    print(s[0] + str(len(s)-2) + s[-1])

if __name__ == "__main__": main()
