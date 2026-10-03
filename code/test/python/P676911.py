#!/usr/bin/env python
# -*- coding: utf-8 -*-

from heapq import heappush, heappop
def dijkstra(adjList,s):
    num = len(adjList)
    dist = [10**12 for i in range(num)]
    prev = [-1 for i in range(num)]
    queue = []

    heappush(queue,(0,s))
    dist[s] = 0
    while queue != []:
        v_cost, v = heappop(queue)
        if dist[v] < v_cost:
            continue
        for u_cost, u in adjList[v]:
            if u != v and u_cost + dist[v] < dist[u]:
                prev[u] = v
                dist[u] = u_cost + dist[v]
                heappush(queue, (dist[u], u))
    return dist,prev

N,M,T = map(int,input().split())

A = list(map(int,input().split()))
G1 = [[] for i in range(N)]
G2 = [[] for i in range(N)]

for i in range(M):
    a,b,c = map(int,input().split())
    a -= 1;b -= 1;
    G1[a].append((c,b))
    G2[b].append((c,a))

dist1, _ = dijkstra(G1, 0)
dist2, _ = dijkstra(G2, 0)

ans = 0
for i in range(N):
    ans = max(ans, (T - (dist1[i] + dist2[i]))*A[i])
print(ans)
