import heapq
V, E = map(int, input().split())
edges = [[] for i in range(V)]
costs = [[0]*V for i in range(V)]

for i in range(E):
    a, b, c = map(int, input().split())
    edges[a-1].append(b-1)
    edges[b-1].append(a-1)
    costs[a-1][b-1], costs[b-1][a-1] = c, c

result = 999999999999999
memo = [None]*V
rooted = set()

def solve(i):
    rooted.add(i)
    for child in (j for j in edges[i] if not j in rooted):
        solve(child)
        edges[child].remove(i)
    
    global result, memo
    unvisited = set([j for j in range(V) if not memo[j] and i!=j])
    vertices = [memo[j][i] if memo[j] else 999999999 for j in range(V)]
    vertices[i] = 0
    q = [(0, i)] + [(memo[j][i], j) for j in range(V) if memo[j]]
    while q and unvisited:
        cost, pos = heapq.heappop(q)
        if pos in unvisited:
            unvisited.remove(pos)
        for to, newcost in ((t, cost+costs[pos][t]) for t in edges[pos] if not memo[t] and vertices[t]>cost+costs[pos][t]):
            vertices[to] = newcost
            heapq.heappush(q, (newcost, to))

    memo[i] = vertices[:]
    result = min(result, max(vertices))

solve(0)
print(result)