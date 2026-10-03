n,x=map(int,input().split())
a=list(map(int,input().split()))
ans=0

for i in range(n-1):
    overflow = a[i]+a[i+1]-x
    if overflow >0:
        ans += overflow
        if a[i+1]>= overflow:
            a[i+1] -= overflow
        else:
            a[i] -= overflow -a[i+1]
            a[i+1]=0
 
print(ans)
