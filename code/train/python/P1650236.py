# coding:utf-8

import numpy as np


def dfs(i, g):
    global n_matrix
    global visited
    if i == g:
        return 1
    visited[i] = 1
    cand = np.nonzero(n_matrix[i, :])[0]
    for c in cand:
        if visited[c] == 0 and dfs(c, g) > 0:
            n_matrix[i, c] = 0
            n_matrix[c, i] = 1
            return 1
    return -1


N, G, E = map(int, input().strip().split(' '))
# 隣接行列n_matrix
# Gのノードからメールを閲覧するというノード[N]にエッジを足してすべて辺のカットの問題にする
n_matrix = np.zeros([N + 1, N + 1], dtype=np.int8)
for i in input().strip().split(' '):
    if i != '':
        n_matrix[int(i), N] = 1
for i in range(E):
    a, b = map(int, input().strip().split(' '))
    n_matrix[a, b] = 1
    n_matrix[b, a] = 1

# max flowを求める
visited = [0] * (N + 1)
tractable = dfs(0, N)
flow = 0
while tractable > 0:
    flow += 1
    for i in range(N + 1):
        visited[i] = 0
    tractable = dfs(0, N)
print(flow)
