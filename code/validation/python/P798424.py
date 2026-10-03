A,K=map(int,input().split())
# A,K=[567876543,0]
l=int(2e12)
i=0
if K==0:
	i=l-A
else:
	while A < l:
		i+=1
		A = 1 + A*(K+1)
		# print(A)
print(i)