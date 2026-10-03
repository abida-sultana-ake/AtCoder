from collections import defaultdict, Counter
from itertools import product, groupby, count
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10


def main():
    N = int(input())
    A_list = list(map(int, input().split()))
    c = Counter(A_list)

    x = []
    for length, n in sorted(c.items(), key=lambda x: x[0], reverse=True):
        if n >= 4:
            x += [length] * 4
        elif n >= 2:
            x += [length] * 2
    x += [0] * 4
    print(x[0] * x[2])

if __name__ == '__main__':
    main()
