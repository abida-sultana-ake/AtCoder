import numpy as np
N,M=map(int,input().split())
g=(1-np.identity(N,int))*1000000
for _ in range(M):
  a,b=map(int,input().split())
  g[a-1][b-1]=g[b-1][a-1]=1
for k in range(N):
  for i in range(N):
    for j in range(N):
      g[i][j]=min(g[i][j],g[i][k]+g[k][j])
for i in range(N):
  print(sum(g[i] == 2))