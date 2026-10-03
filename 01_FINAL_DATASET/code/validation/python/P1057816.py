n, m = map(int, input().split())
abc = []
dis = [[float('inf')]*n for _ in range(n)]
for _ in range(m):
    abc.append(list(map(int, input().split())))

for a, b, c in abc:
    dis[a-1][b-1] = c
    dis[b-1][a-1] = c

for k in range(n):
    for i in range(n):
        for j in range(n):
            dis[i][j] = min(dis[i][j], dis[i][k]+dis[k][j])

count = 0
for a, b, c in abc:
    if c > dis[a-1][b-1]:
        count += 1

print(count)