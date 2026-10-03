from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
from math import factorial
INF = 10 ** 10


def comb(n, r):
    if n < r:
        return 0
    else:
        return factorial(n) // factorial(r) // factorial(n - r)


def calc(area, D, L):
    return comb(area, D) * comb(area - D, L)


def main():
    MOD = 10 ** 9 + 7
    R, C = map(int, input().split())
    X, Y = map(int, input().split())
    D, L = map(int, input().split())

    ans = calc(X * Y, D, L)

    if D + L != X * Y:
        # A: 上についていない、B:下についていない, C:左についていない, D:右についていない
        # n(A∪B∪C∪D) = n(A) + n(B) + n(C) + n(D)
        #              − n(A∩B) − n(A∩C) − n(A∩D) − n(B∩C) − n(B∩D) − n(C∩D)
        #              + n(A∩B∩C) + n(A∩B∩D) + n(A∩C∩D) + n(B∩C∩D)
        #              − n(A∩B∩C∩D)

        ans -= calc((X - 1) * Y, D, L) * 2          # n(A), n(B)
        ans -= calc(X * (Y - 1), D, L) * 2          # n(C), n(D)

        ans += calc((X - 2) * Y, D, L)              # n(A∩B)
        ans += calc(X * (Y - 2), D, L)              # n(C∩D)
        ans += calc((X - 1) * (Y - 1), D, L) * 4    # n(A∩D), n(B∩C), n(B∩D), n(C∩D)

        ans -= calc((X - 2) * (Y - 1), D, L) * 2    # n(A∩B∩C), n(A∩B∩D)
        ans -= calc((X - 1) * (Y - 2), D, L) * 2    # n(A∩C∩D), n(B∩C∩D)

        ans += calc((X - 2) * (Y - 2), D, L)        # n(A∩B∩C∩D)

    print((ans * (R - X + 1) * (C - Y + 1)) % MOD)

if __name__ == '__main__':
    main()
