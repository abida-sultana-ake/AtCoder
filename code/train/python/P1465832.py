# coding: utf-8
from queue import Queue

N, M = tuple(map(int, input().split()))

graph = [ [] for i in range(N+1)]
for i in range(M):
    a, b = tuple(map(int, input().split()))
    graph[a].append(b)
    graph[b].append(a)

def is_reach(n):
    dist = [0 for i in range(N+1)]
    is_visit = [False for i in range(N+1)]
    is_visit[1] = True
    q = Queue()
    q.put(1)
    while not q.empty():
        v = q.get()
        for u in graph[v]:
            if not is_visit[u]:
                is_visit[u] = True
                q.put(u)
                dist[u] = dist[v] + 1
                if u == n and dist[u] == 2:
                    return True
                if dist[u] > 2:
                    return False
    return False

print("POSSIBLE" if is_reach(N) else "IMPOSSIBLE")
