# -*- coding: utf-8 -*-
"""
https://beta.atcoder.jp/contests/abc075/tasks/abc075_c

"""
import sys
from sys import stdin
from collections import deque
input = stdin.readline



def solve(es, degrees, N, M):
    bridge = 0
    Q = []

    for i in range(1, N+1):
        if degrees[i] == 1:
            Q.append(i)

    while Q:
        u = Q.pop()
        bridge += 1
        for e in es[u]:
            degrees[e] -= 1
            if degrees[e] == 1:
                Q.append(e)

    return bridge



def main(args):
    N, M = map(int, input().split())

    degrees = [0] * (N + 1)
    es = [[] for _ in range(N + 1)]
    for _ in range(M):
        a, b = map(int, input().split())
        es[a].append(b)
        es[b].append(a)
        degrees[a] += 1
        degrees[b] += 1

    result = solve(es, degrees, N, M)
    print(min(result, M))



if __name__ == '__main__':
    main(sys.argv[1:])
    
