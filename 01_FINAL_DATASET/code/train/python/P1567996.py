from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10


def main():
    x, y = map(int, input().split())
    print(y // x)


if __name__ == '__main__':
    main()
