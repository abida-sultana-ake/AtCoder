import sys
from collections import Counter

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    N, A = map(int, input().split())
    x = [int(i) for i in input().split()]

    # 3d DP
    max_x = max(x)

    dp = [[[0] * (max_x * N + 1) for j in range(N + 1)]
                                 for i in range(N + 1)]

    dp[0][0][0] = 1

    for i in range(0, N):
        for k in range(0, N + 1):
            for y in range(max_x * N + 1):
                if dp[i][k][y]:
                    dp[i + 1][k][y] += dp[i][k][y]
                    dp[i + 1][k + 1][y + x[i]] += dp[i][k][y]

            # print(dp[i][k])
        # print()

    cnt = 0
    for k in range(1, N + 1):
        for y in range(1, max_x * N + 1):
            if y // k == A and y % k == 0:
                cnt += dp[N][k][y]

    print(cnt)

if __name__ == '__main__':
    solve()