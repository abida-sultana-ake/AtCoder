n=input()
a=map(int,raw_input().split())
ans=10**9
for j in xrange(-100,101):
    asum=0
    for i in xrange(n):
        asum+=(a[i]-j)**2
    ans=min(ans,asum)
print(ans)
