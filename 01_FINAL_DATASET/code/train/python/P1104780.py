n, m = map(int, input().split())
A = [[114514893 for i in range(n)] for j in range(n)]
ans = 0

visited = [0 for i in range(n)]


def dfs(src):
    global ans
    if sum(visited) == n: ans += 1
    for dst in range(n):
        if src == dst: continue
        if visited[dst] or A[src][dst] != 1: continue
        visited[dst] = 1
        dfs(dst)
        visited[dst] = 0


for i in range(m):
    a, b = map(int, input().split())
    a -= 1;
    b -= 1;
    A[a][b] = 1
    A[b][a] = 1

visited[0] = 1
dfs(0)
print(ans)
