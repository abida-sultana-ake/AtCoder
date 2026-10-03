from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10


def main():
    n = int(input())
    dp = [0] * 1000002
    for _ in range(n):
        a, b = map(int, input().split())
        dp[a] += 1
        dp[b + 1] -= 1

    for i in range(len(dp) - 1):
        dp[i + 1] += dp[i]

    print(max(dp))


if __name__ == '__main__':
    main()
