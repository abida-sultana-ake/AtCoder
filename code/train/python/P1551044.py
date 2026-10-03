from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10


def main():
    X = input()
    while X:
        for c in ("ch", "o", "k", "u"):
            if X.endswith(c):
                X = X[:-len(c)]
                break
        else:
            break

    print("NO" if X else "YES")


if __name__ == '__main__':
    main()
