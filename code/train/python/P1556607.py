N,M = map(int,input().split())
ds = [i+1 for i in range(N)]
now = 0
for i in range(M):
    d = int(input())
    if d == now: continue
    x = ds.index(d)
    ds[x],now = now,ds[x]

for d in ds: print(d)
