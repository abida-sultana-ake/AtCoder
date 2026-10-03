N = int(input())
D = [[int(i) for i in input().split()] for _ in range(N)]
Q = int(input())
P = [int(input()) for _ in range(Q)]

dp = [[0] * (N + 1) for _ in range(N + 1)]


for i in range(N)[::-1]:
    for j in range(N)[::-1]:
        dp[i][j] = dp[i + 1][j] + dp[i][j + 1] - dp[i + 1][j + 1] + D[i][j]

#DP


score = [0] * (N ** 2 + 1)

for i in range(N): #0 T N-1
    for j in range(N): #0 T N-1
        for k in range(i + 1, N + 1): # i+1 T N
            for l in range(j + 1, N + 1): #j+1 T N
                s = (k - i) * (l - j)
                score[s] = max(score[s], dp[i][j] - dp[k][j] - dp[i][l] + dp[k][l])


for i in range(1, len(score)):
    score[i] = max(score[i - 1], score[i])

for i in P:
    print(score[i])
