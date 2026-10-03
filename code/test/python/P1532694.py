from collections import defaultdict
from itertools import product
from math import pi


def main():
    N, T = map(int, input().split())
    dp = [0] * (10 ** 6 + 2 * T)
    for _ in range(N):
        a = int(input())
        dp[a] += 1
        dp[a + T] -= 1
    for i in range(len(dp) - 1):
        dp[i + 1] += dp[i]
    print(len(dp) - dp.count(0))


if __name__ == '__main__':
    main()
