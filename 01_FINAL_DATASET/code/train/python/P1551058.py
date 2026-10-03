from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10


def main():
    N, M = map(int, input().split())
    dp = [0] * (M + 1)
    total = 0
    for _ in range(N):
        l, r, s = map(int, input().split())
        total += s
        dp[l - 1] += s
        dp[r] -= s

    for i in range(len(dp) - 1):
        dp[i + 1] += dp[i]

    ans = 0
    for i in range(len(dp) - 1):
        ans = max(ans, total - dp[i])
    print(ans)


if __name__ == '__main__':
    main()
