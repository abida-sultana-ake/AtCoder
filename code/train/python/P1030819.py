#!/usr/bin/env python3


def min_turns(n, x, ys):
    zs = ys[:]
    if zs[0] > x:
        zs[0] = x
    for i in range(n - 1):
        if zs[i] + zs[i + 1] > x:
            zs[i + 1] = x - zs[i]
    ans = sum(y - z for y, z in zip(ys, zs))
    return ans


def main():
    n, x = (int(z) for z in input().split())
    ys = [int(z) for z in input().split()]
    print(min_turns(n, x, ys))


if __name__ == '__main__':
    main()
