import math

n,m = map(int,input().split())
if(abs(n-m)>1):
	print("0")
else:
	x = math.factorial(n)
	y = math.factorial(m)
	md = 1000000007
	if(n==m):
		print(((x%md)*(y%md)*2)%md)
	else:
		print(((x%md)*(y%md))%md)