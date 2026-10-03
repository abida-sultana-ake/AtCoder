from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10


# 初項a，数列n個の和
def total(a, n):
    return n * (2 * a + (n - 1)) // 2


def calc(m, l, r):
    if l <= m <= r:
        return total(0, m - l + 1) + total(0, r - m + 1)
    elif r < m:
        return total(m - r, r - l + 1)
    elif m < l:
        return total(l - m, r - l + 1)


def main():
    R, G, B = map(int, input().split())
    ans = INF
    for left in range(400, 1600):
        right = left + G - 1

        # G
        cost = calc(1000, left, right)

        # R
        r = min(900 + R // 2, left - 1)
        l = r - R + 1
        cost += calc(900, l, r)

        # B
        l = max(1100 - B // 2, right + 1)
        r = l + B - 1
        cost += calc(1100, l, r)

        ans = min(ans, cost)

    print(ans)


if __name__ == '__main__':
    main()
