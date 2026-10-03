n,d=map(int,input().split())
x,y=map(int,input().split())
fact=[0]*(n+1)
fact[0]=1
for i in range(1,n+1):fact[i]=fact[i-1]*i
ans=0
for i in range(n+1):
	a=i*d-x;b=(n-i)*d-y
	if a<0 or b<0 or a%(2*d) or b%(2*d):continue
	a//=(2*d);b//=(2*d)
	ans+=fact[n]//(fact[a]*fact[i-a]*fact[b]*fact[n-i-b])
print("%.18f"%(ans/4**n))