n,m=map(int,input().split());d=[0]*(1<<n);b=[0]*n;d[0]=1
for i in range(m):x,y=map(int,input().split());b[y-1]|=1<<x-1
for i in range(1<<n):
	for j in range(n):
		if (i>>j&1)==0 and (i|b[j])==i:d[i|1<<j]+=d[i]
print(d[-1])