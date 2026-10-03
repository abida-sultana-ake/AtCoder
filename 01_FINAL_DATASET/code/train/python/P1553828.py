from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10


def main():
    a, b = int(input()), int(input())
    ans = 10 ** 10
    for i in range(10):
        if (a + i) % 10 == b:
            ans = min(ans, i)
        if (a - i) % 10 == b:
            ans = min(ans, i)
    print(ans)


if __name__ == '__main__':
    main()
