from collections import defaultdict
def primefactor(x):
    fac=defaultdict(int)
    for i in xrange(2,int(x**0.5)+1):
        while x%i==0:
            fac[i]+=1
            x=x/i
    if x!=1:
        fac[x]+=1
    return fac

n=int(raw_input())
mod=10**9+7
ans=1
cnt=defaultdict(int)
for i in xrange(1,n+1):
    tmp=primefactor(i)
    for j,k in tmp.items():
        cnt[j]+=k
for i,j in cnt.items():
    ans=ans*(j+1)%mod
print(ans%mod)
