# -*- coding: utf-8 -*-
"""
http://abc065.contest.atcoder.jp/tasks/arc076_a

"""
import sys
from sys import stdin
input = stdin.readline


def main(args):
    N, M = map(int, input().split())

    res = 0
    if N == M:
        combi_N = 1
        for i in range(1, N+1):
            combi_N *= i
            combi_N %= 1000000007
        combi_M = 1
        for i in range(1, M+1):
            combi_M *= i
            combi_M %= 1000000007
        res = combi_N * combi_M * 2
        res %= 1000000007
    elif (N + 1) == M or (M + 1) == N:
        combi_N = 1
        for i in range(1, N+1):
            combi_N *= i
            combi_N %= 1000000007
        combi_M = 1
        for i in range(1, M+1):
            combi_M *= i
            combi_M %= 1000000007
        res = combi_N * combi_M
        res %= 1000000007

    print(res)


if __name__ == '__main__':
    main(sys.argv[1:])