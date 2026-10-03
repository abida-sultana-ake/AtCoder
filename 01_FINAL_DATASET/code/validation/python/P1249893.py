#!/usr/bin/env python3


def solve(n, u, ts):
    res = 0
    end = 0
    for t in ts:
        res += min(u - end + t, u)
        end = u + t
    return res


def main():
    n, u = (int(x) for x in input().split())
    ts = [int(x) for x in input().split()]
    print(solve(n, u, ts))


if __name__ == '__main__':
    main()
