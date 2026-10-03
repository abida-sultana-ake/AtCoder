N = int(input())
D = [list(map(int, input().split())) for _ in range(N)]
Q = int(input())
P = [int(input()) for x in range(Q)]

rb = N - 1
dp = [[0] * (N + 1) for _ in range(N + 1)]
# 右下までのPTを求める
for r in range(N - 1, -1, -1):
    for c in range(N - 1, -1, -1):
        dp[r][c] = D[r][c] + dp[r + 1][c] + dp[r][c + 1] - dp[r + 1][c + 1]

# 焼けるたこ焼きごとの最大PTを求める
m = max(P)
max_pt = [0] * ((N ** 2) + 1)
for r in range(N):
    for c in range(N):
        for r2 in range(r, N + 1):
            for c2 in range(c, N + 1):
                tmp = dp[r][c] - dp[r][c2] - dp[r2][c] + dp[r2][c2]
                cnt = (r2 - r) * (c2 - c)
                max_pt[cnt] = max(max_pt[cnt], tmp)

for i in range(1, (N ** 2) + 1):
    max_pt[i] = max(max_pt[i], max_pt[i - 1])

for p in P:
    print(max_pt[p])
