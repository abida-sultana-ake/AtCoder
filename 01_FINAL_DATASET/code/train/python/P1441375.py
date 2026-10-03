n=int(input())
pt=[[] for i in range(n)]
for i in range(n-1):
    a,b=map(int,input().split())
    pt[a-1].append(b-1)
    pt[b-1].append(a-1)

def dfs(v):
    d=[-1 for i in range(n)]
    q=[]
    d[v]=0
    q.append(v)
    while q:
        v=q.pop()
        for i in pt[v]:
            if d[i]==-1:
                d[i]=d[v]+1
                q.append(i)
    return d

l1=dfs(0)
l2=dfs(n-1)
po=0
for i in range(n):
    if l1[i]<=l2[i]:
        po+=1

if po>n/2:
    print("Fennec")
else:
    print("Snuke")
