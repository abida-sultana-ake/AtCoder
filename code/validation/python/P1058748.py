n,m = map(int,input().split())
abc = []

dist = [[float('inf')] * n for _ in range(n)]
for i in range(n):
  dist[i][i] = 0
for _ in range(m):
  abc.append(list(map(int,input().split())))

for a,b,c in abc:
  dist[a-1][b-1] = c
  dist[b-1][a-1] = c
for k in range(n):
    for i in range(n):
      for j in range(n):
          dist[i][j] = min(dist[i][j],dist[i][k]+dist[k][j])

ans = 0
for a,b,c in abc:
    if dist[a-1][b-1]  < c:
        ans += 1

print(ans)