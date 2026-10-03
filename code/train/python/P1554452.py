from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10


def nCr(n):
    table = [[None] * (n + 1) for _ in range(n + 1)]
    for i in range(n + 1):
        for j in range(i + 1):
            if j == 0 or j == i:
                table[i][j] = 1
            else:
                table[i][j] = table[i - 1][j - 1] + table[i - 1][j]
    return table


def main():
    N, D = map(int, input().split())
    X, Y = map(int, input().split())
    X, Y = abs(X), abs(Y)
    if X % D != 0 or Y % D != 0:
        print(0)
        return
    a, b = X // D, Y // D

    if (N - (a + b)) % 2 != 0:
        print(0)
        return

    comb = nCr(1001)

    ans = 0
    for i in range(N + 1):
        h, v = i, N - i
        if h < a or v < b or (h - a) % 2 == 1 or (v - b) % 2 == 1:
            continue
        ans += comb[h][h - (h - a) // 2] * comb[v][v - (v - b) // 2] * comb[N][i]

    print("{0:.10f}".format(ans / 4 ** N))


if __name__ == '__main__':
    main()
