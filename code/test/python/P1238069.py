N=int(input())
a=[int(i) for i in input().split()]
ans=[]
for mode in range(2):
	tempans=0
	sumA=0
	#print(sumA)
	for i in range(0,N):
		#above 0
		sumA+=a[i]
		if (i+mode)%2==0:
			if sumA<=0:
				tempans-=(sumA-1)
				sumA=1
		else:
			if sumA>=0:
				tempans+=(sumA+1)
				sumA=-1
		#print(sumA)
	ans.append(tempans)
print(min(ans))