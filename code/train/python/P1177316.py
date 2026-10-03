from collections import deque
mod=10**9+7
n=int(raw_input())
a,b=map(int,raw_input().split())
a-=1;b-=1
m=int(raw_input())
g=[[] for _ in xrange(n)]
for i in xrange(m):
    x,y=map(int,raw_input().split())
    x-=1;y-=1
    g[x].append([y,i])
    g[y].append([x,i])

q=deque([a])
mindist=[m+1]*n
mindist[a]=0
visited=[False]*n
visited[a]=True
dp=[0]*n
dp[a]=1
while len(q)>0:
    now=q.popleft()
    for nx,e in g[now]:
        if mindist[now]+1<=mindist[nx]:
            if not visited[nx]:
                visited[nx]=True
                q.append(nx)
            mindist[nx]=mindist[now]+1
            dp[nx]+=dp[now]%mod
            dp[nx]=dp[nx]%mod
print(dp[b]%mod)
