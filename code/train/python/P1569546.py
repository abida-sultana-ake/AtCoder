from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10


def main():
    N, K = map(int, input().split())
    R_list = list(sorted(list(map(int, input().split()))))[-K:]
    C = 0
    for i in range(K):
        C = (C + R_list[i]) / 2
    print("{0:.7f}".format(C))


if __name__ == '__main__':
    main()
