import sys
from collections import deque
readline = sys.stdin.readline

N = int(readline())
edges = [[] for _ in [None]*N]
for _ in [None]*(N-1):
    a, b = map(int, input().split())
    edges[a-1].append(b-1)
    edges[b-1].append(a-1)


def bfs(n, edges, start):
    dq = deque()
    append, pop = dq.append, dq.popleft
    distances = [None]*n
    distances[start] = 0

    append((start, 0))
    while dq:
        pos, cost = pop()
        cost += 1
        for dest in edges[pos]:
            if distances[dest] is None:
                distances[dest] = cost
                append((dest, cost))

    return distances


fennec_map = bfs(N, edges, 0)
snuke_map = bfs(N, edges, N-1)
fennec = snuke = 0
for f, s in zip(fennec_map, snuke_map):
    if f <= s:
        fennec += 1
    else:
        snuke += 1

print("Fennec" if fennec > snuke else "Snuke")