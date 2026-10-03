n=int(input())
a=input().split()
for i in range(n):
    a[i]=int(a[i])

su=0
for i in range(n):
    su+=a[i]
best = abs(su-2*a[0])
curr=0
for i in range(n-1):
    curr+=a[i]
    diff=abs(su-2*curr)
    best=min(best,diff)

print (best)
