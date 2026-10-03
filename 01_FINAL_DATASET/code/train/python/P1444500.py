# coding: utf-8

from queue import Queue

N = int(input())
graph = [ list() for i in range(N+1)]
for i in range(N - 1):
    a, b = tuple(map(int, input().split()))
    graph[a].append(b)
    graph[b].append(a)

def search(start):
    dist = [0 for i in range(N+1)]
    is_visit = [False for i in range(N+1)]
    is_visit[start] = True
    q = Queue()
    q.put(start)

    while not q.empty():
        v = q.get()
        for u in graph[v]:
            if not is_visit[u]:
                is_visit[u] = True
                q.put(u)
                dist[u] = dist[v] + 1
    return dist

win_f = 0
win_s = 0
for f, s in zip(search(1)[2:N], search(N)[2:N]):
    if f <= s:
        win_f += 1
    else:
        win_s += 1
print("Fennec" if win_f > win_s else "Snuke")
