import math
n=math.factorial(int(input()))
i=2
res=1
MOD=1000000007
while i*i<=n:
	cnt=1
	while n%i==0:
		cnt+=1
		n//=i
	res*=cnt
	i+=1
if n!=1:res*=2
print(res%MOD)