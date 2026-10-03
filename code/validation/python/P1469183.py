n,m=map(int,input().split())
s=[False]*200001
g=[False]*200001
r='POSSIBLE'
for _ in range(m):
    a,b=map(int,input().split())
    if a==1:
        if g[b]:
            break
        s[b]=True
    elif b==n:
        if s[a]:
            break
        g[a]=True
else:
    r='IMPOSSIBLE'
print(r)