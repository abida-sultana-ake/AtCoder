# -*- coding: utf-8 -*-
"""
https://beta.atcoder.jp/contests/abc074/tasks/abc074_a

"""
import sys
from sys import stdin
input = stdin.readline


def main(args):
    N = int(input())
    A = int(input())
    print(N**2 - A)


if __name__ == '__main__':
    main(sys.argv[1:])
    