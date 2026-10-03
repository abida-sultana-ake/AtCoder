# -*- coding: utf-8 -*-
# problem D
MAX = 9999 # c_i <= 1000 より.

n, m = map(int, input().split())
cost = []

dist = [[MAX] * n for _ in range(n)]
for i in range(n):
    dist[i][i] = 0
    
for _ in range(m):
    cost.append(list(map(int, input().split())))

for a, b, c in cost:
    dist[a-1][b-1] = c
    dist[b-1][a-1] = c

# Warshall-Floyd Algorithm
for k in range(n):
    for i in range(n):
        for j in range(n):
            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

ans = 0
for a, b, c in cost:
    if dist[a-1][b-1] < c:
        ans += 1
        
print(ans)