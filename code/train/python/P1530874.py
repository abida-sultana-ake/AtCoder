from collections import defaultdict
from itertools import product
from math import sin, pi


def func(t, A, B, C):
    return A * t + B * sin(C * t * pi)


def main():
    A, B, C = map(int, input().split())

    # [low, high)
    low, high = 0, 100000
    for _ in range(10000):
        t = (low + high) / 2
        if func(t, A, B, C) < 100:
            ans = t
            low = t
        else:
            high = t

    print(ans)


if __name__ == '__main__':
    main()
