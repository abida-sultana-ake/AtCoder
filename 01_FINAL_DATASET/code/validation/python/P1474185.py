n,m=map(int,input().split())
name=input()
kit=input()
Alpha=ord('Z')-ord('A')+1
ncnt=[0]*Alpha
kcnt=[0]*Alpha
for c in name:
    ncnt[ord(c)-ord('A')]+=1
for c in kit:
    kcnt[ord(c)-ord('A')]+=1
INF=1e9
res=0
for i in range(0,Alpha):
    if ncnt[i]==0:
        continue
    if kcnt[i]==0:
        res=INF
        continue
    res=max(res,ncnt[i]//kcnt[i]+(ncnt[i]%kcnt[i]!=0))
if res!=INF: print(res)
else: print(-1)
