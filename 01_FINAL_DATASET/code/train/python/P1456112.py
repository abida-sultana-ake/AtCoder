def bf(edges, start, N):
    INF = float('inf')
    costs = [INF] * N
    costs[start] = 0
    for i in range(N):
        for f, t, c in edges:
            if costs[f] != INF and costs[f] + c < costs[t]:
                costs[t] = costs[f] + c
                if i == N-1 and t == N-1:
                    return 'inf'
    return -costs[N-1]

N, M = map(int, input().split())
edges = []
for _ in range(M):
    f, t, c = map(int, input().split())
    edges.append((f-1, t-1, -c))

print(bf(edges, 0, N))
