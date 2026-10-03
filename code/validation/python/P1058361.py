
# D - Candidates of No Shortest Paths

MAXI = 999999999

# 入力
N, M = map(int, input().split())
cost = [[-1 for i in range(N)] for j in range(N)]

for i in range(M):
    a, b, c = map(int, input().split())
    cost[a - 1][b - 1] = c
    cost[b - 1][a - 1] = c

# iからjへの最短距離を表すテーブルの初期化
dist = [[MAXI for i in range(N)] for j in range(N)]

# iからjへの辺があったら、最短距離をその辺のコストで初期化
for i in range(N):
    for j in range(N):
        if i == j:
            dist[i][j] = 0
        elif cost[i][j] != -1:
            dist[i][j] = cost[i][j]
            dist[j][i] = dist[i][j]

# ワーシャルフロイドで各i,j間の最短距離を求めておく
for k in range(N):
    for i in range(N):
        for j in range(N):
            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

ans = 0

for i in range(N):
    for j in range(i, N):
        # i,j間に辺があって、そこを通らない方が近道になるとき、全ての最短経路でその辺は使われない
        if cost[i][j] != -1 and cost[i][j] != dist[i][j]:
            ans += 1

print(ans)