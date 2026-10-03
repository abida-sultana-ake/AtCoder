n,k=map(int,input().split())
r=list(map(int,input().split()))
c=0
r.sort()
for i in range(n-k,n):
    c=(r[i]+c)/2
print(c)