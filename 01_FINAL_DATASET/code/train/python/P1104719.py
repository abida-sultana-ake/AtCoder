#!/usr/bin/env python3

import itertools


def count_paths(n, adj_list):
    res = 0
    for vs in itertools.permutations(range(n)):
        if vs[0] != 0:
            continue
        for i in range(n - 1):
            if vs[i] not in adj_list[vs[i + 1]]:
                break
        else:
            res += 1
    return res


def main():
    n, m = (int(x) for x in input().split())
    adj_list = [set() for _ in range(n)]
    for _ in range(m):
        a, b = (int(y) - 1 for y in input().split())
        adj_list[a].add(b)
        adj_list[b].add(a)
    print(count_paths(n, adj_list))


if __name__ == '__main__':
    main()
