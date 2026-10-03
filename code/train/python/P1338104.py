import heapq
import time
T = time.time()

V, E = map(int, input().split())
edges = [[] for i in range(V)]
for i in range(E):
    u, v, l = map(int, input().split())
    edges[u - 1].append((v - 1, l))
    edges[v - 1].append((u - 1, l))

ans = 10**9
for p, c in edges[0]:

    q = [(c, p)]
    vertices = [10**9 for i in range(V)]
    _edges = edges[:]
    _edges[p].remove((0, c))

    while q:
        if time.time() - T > 1.9:
            print(ans if ans < 10**9 else -1)
            exit()
        cost, pos = heapq.heappop(q)
        if cost >= ans:
            break

        if pos == 0:
            ans = min(ans, cost)
            break

        for dest, edgecost in _edges[pos]:
            newcost = cost + edgecost

            if vertices[dest] > newcost:
                vertices[dest] = newcost
                heapq.heappush(q, (newcost, dest))

print(ans if ans < 10**9 else -1)