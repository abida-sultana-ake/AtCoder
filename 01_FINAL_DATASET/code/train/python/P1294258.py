import sys

sys.setrecursionlimit(10**7)

inf = 1<<60

def solve():
    N, M = map(int, sys.stdin.readline().split())
    edges = [None] * M
    Adj = [[] for i in range(N)]

    for i in range(M):
        ai, bi, ci = map(int, sys.stdin.readline().split())
        edges[i] = (ai - 1, bi - 1, -ci)
        Adj[bi - 1].append(ai - 1)

    reachable = [False] * N
    reachable[N - 1] = True
    dfs(N, Adj, reachable, N - 1)

    edges = [(ai, bi, ci) for (ai, bi, ci) in edges if reachable[ai] and reachable[bi]]

    ans = BellmanFord(N, M, edges)

    if ans is None:
        print('inf')
    else:
        print(-ans)

    pass

def dfs(N, Adj, visited, u):
    for v in Adj[u]:
        if not visited[v]:
            visited[v] = True
            dfs(N, Adj, visited, v)

def BellmanFord(N, M, edges):
    d = [inf] * N
    d[0] = 0

    for i in range(N - 1):
        for (ai, bi, ci) in edges:
            if d[ai] != inf and d[ai] + ci < d[bi]:
                d[bi] = d[ai] + ci

    for (ai, bi, ci) in edges:
        if d[ai] != inf and d[ai] + ci < d[bi]:
            return None

    return d[N - 1]

if __name__ == '__main__':
    solve()