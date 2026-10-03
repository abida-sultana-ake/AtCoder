N=int(input())
A=int(input())
B=int(input())
C=int(input())
vis = [ 999 ] * (333)
vis[N] = 0
for _ in range(100):
  vis[A] = 999
  vis[B] = 999
  vis[C] = 999
  for i in range(N+1):
    if vis[i + 1] >= 0 : vis[i] = min(vis[i], 1 + vis[i+1])
    if vis[i + 2] >= 0 : vis[i] = min(vis[i], 1 + vis[i+2])
    if vis[i + 3] >= 0 : vis[i] = min(vis[i], 1 + vis[i+3])
if vis[0] <= 100:
  print("YES")
else:
  print("NO")
