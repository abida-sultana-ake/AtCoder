n,m = map(int, input().split())
g = [[] for i in range(n)]
for i in range(m):
    a,b,c = map(int, input().split())
    a -= 1
    b -= 1
    g[a].append((b, -c))
        
dist = [float('inf') for i in range(n)]
dist[0] = 0
prev = [-1 for i in range(n)]
negative_cycle = False
for k in range(n):
    for i in range(n):
        for dst, cst in g[i]:
            src = i
            if dist[dst] > dist[src] + cst:
                dist[dst] = dist[src] + cst
                prev[dst] = src
                if k == n-1 and dst == n-1:
                    dist[dst] = -float('inf')
                    negative_cycle = True

if negative_cycle:
    print('inf')
else:
    print(-dist[n-1])
