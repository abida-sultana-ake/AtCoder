N,M=list(map(int,input().split()))
d=[int(input()) for _ in [1]*M]    

ds=list(range(1,N+1))
c=0
for di in d:
    if di!=c:
        i=ds.index(di)
        tmp=ds[i]
        ds[i]=c
        c=tmp
    
for dsi in ds:
    print(dsi)