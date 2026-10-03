from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10


def triangle(y1, x1, y2, x2, y3, x3):
    return abs(x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1) / 2


def main():
    x1, y1, x2, y2, x3, y3 = map(int, input().split())
    print(triangle(y1, x1, y2, x2, y3, x3))


if __name__ == '__main__':
    main()
