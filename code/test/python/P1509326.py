n = int(input())
g = []
d = [0] * (n + 1)
for i in range(n + 1):
    g.append([]);
for i in range(n - 1):
    u, v, w = map(int, input().split())
    g[u].append([v, w])
    g[v].append([u, w])
q, k = map(int, input().split())
def bfs(u):
    s = []
    s.append(u)
    while s:
        v = s[-1]
        s.pop()
        for go in g[v]:
            if not d[go[0]] and go[0] != u:
                d[go[0]] = d[v] + go[1]
                s.append(go[0])
bfs(k)
while q > 0:
    u, v = map(int, input().split())
    print(d[u] + d[v])
    q -= 1
