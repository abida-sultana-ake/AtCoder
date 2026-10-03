N, G, E = [int(_) for _ in input().split()]

conn_mat = [[0] * (N + 1) for _ in range(N + 1)]

for g in input().split():
    conn_mat[int(g)][N] = 1
    conn_mat[N][int(g)] = 1

for _ in range(E):
    a, b = [int(_) for _ in input().split()]
    conn_mat[a][b] = 1
    conn_mat[b][a] = 1


def dfs(start=0):
    queue = [[start]]
    visited = []
    while len(queue) > 0:
        history = queue.pop(-1)
        edge = history[-1]
        visited.append(edge)
        for node, conn in enumerate(conn_mat[edge]):
            if conn == 0 or node in visited:
                continue

            next_hist = history + [node]

            if node == N:
                for i in range(len(next_hist) - 1):
                    conn_mat[next_hist[i]][next_hist[i+1]] = 0
                return 1

            queue.append(next_hist)

    return 0

result = 0
while True:
    d = dfs()
    if d == 0:
        print(result)
        break
    else:
        result += d
