# -*- coding: utf-8 -*-
"""
http://abc065.contest.atcoder.jp/tasks/abc065_a

"""
import sys
from sys import stdin
input = stdin.readline


def main(args):
    X, A, B = map(int, input().split())
    if A >= B:
        print('delicious')
    elif (A + X) >= B:
        print('safe')
    else:
        print('dangerous')


if __name__ == '__main__':
    main(sys.argv[1:])