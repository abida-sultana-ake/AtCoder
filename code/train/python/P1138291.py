def nCk(n,k,mod=10**9+7):
    ret=1
    if n<k or k<0 or n<0:return 0
    if n-k<k:
        k=n-k
    for i in xrange(n,n-k,-1):
        ret=ret*i%mod
    fact=[1]*(k+1)
    for i in xrange(1,k+1):
        fact[i]=fact[i-1]*i%mod
    return ret%mod * pow(fact[k],mod-2,mod) % mod

r,c=map(int,raw_input().split())
x,y=map(int,raw_input().split())
d,l=map(int,raw_input().split())
mod=10**9+7
ans=nCk(x*y,d)*nCk(x*y-d,l)%mod
ng=(2*nCk(x*(y-1),d)*nCk(x*(y-1)-d,l)+2*nCk((x-1)*y,d)*nCk((x-1)*y-d,l))%mod
ng-=(4*(nCk((x-1)*(y-1),d)*nCk((x-1)*(y-1)-d,l))+(nCk(x*(y-2),d)*nCk(x*(y-2)-d,l))+(nCk((x-2)*y,d)*nCk((x-2)*y-d,l)))%mod
ng+=(2*nCk((x-2)*(y-1),d)*nCk((x-2)*(y-1)-d,l)+2*nCk((x-1)*(y-2),d)*nCk((x-1)*(y-2)-d,l))%mod
if x>=2 and y>=2:ng-=(nCk((x-2)*(y-2),d)*nCk((x-2)*(y-2)-d,l))%mod
print (ans-ng)*(r-x+1)*(c-y+1)%mod
