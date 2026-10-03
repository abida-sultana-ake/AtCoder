import copy
from itertools import product as prod

n, m = [int(x) for x in input().split()]

wait = [[float("inf") for _ in range(n)] for _ in range(n)]
for i in range(n):
    wait[i][i] = 0
for _ in range(m):
    a, b, c = map(int, input().split())
    wait[a-1][b-1] = c
    wait[b-1][a-1] = c

dist = copy.deepcopy(wait)
for k, i, j in prod(range(n), range(n), range(n)):
    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
    dist[j][i] = min(dist[j][i], dist[j][k] + dist[k][i])

ans = 0
for i, j in prod(range(n), range(n)):
    if not wait[i][j] == float("inf") and dist[i][j] < wait[i][j]:
        ans += 1

print(ans // 2)
