n,m=map(int,raw_input().split())
x=[0]*m
y=[0]*m
for i in xrange(m):
	a,b=map(int,raw_input().split())
	x[i]=a-1
	y[i]=b-1
dp=[0]*(1<<n)
ok=[True]*(1<<n)
for i in xrange(1<<n):
	for j in xrange(m):
		if  (i>>y[j])%2==1  and (i>>x[j])%2!=1:
			ok[i]=False
dp[0]=1
for i in xrange(1<<n):
	if ok[i]:
		for j in xrange(n):
			if (i>>j)%2==1 and ok[i^(1<<j)]:
				dp[i]+=dp[i^(1<<j)]
print(dp[(1<<n)-1])