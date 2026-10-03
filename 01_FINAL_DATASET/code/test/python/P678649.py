from scipy.sparse import *
f=lambda:map(int,raw_input().split())
n,m,t=f()
z=[1]+f()
a,b,c=zip(*[f()for _ in range(m)])
g=csgraph.dijkstra(csr_matrix((c,(a,b)),(n+1,n+1)),indices=1)
h=csgraph.dijkstra(csr_matrix((c,(b,a)),(n+1,n+1)),indices=1)
print(int(max(z[i]*(t-g[i]-h[i])for i in range(n+1))))