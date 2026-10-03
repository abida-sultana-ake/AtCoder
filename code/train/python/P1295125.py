import sys
sys.setrecursionlimit(10**8)
def dfs(now,par):
    for to in g[now]:
        if to==par:continue
        ans[now]+=dfs(to,now)
    if h[now]==1:return ans[now]+1
    else:
        if ans[now]==0:
            return 0
        else:
            return ans[now]+1
n,x=map(int,raw_input().split())
h=map(int,raw_input().split())
g=[[] for _ in xrange(n)]
for i in xrange(n-1):
    a,b=map(int,raw_input().split())
    a-=1;b-=1
    g[a].append(b)
    g[b].append(a)
ans=[0]*n
print (max(dfs(x-1,-1)-1,0))*2
