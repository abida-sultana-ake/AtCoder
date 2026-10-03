#import copy as c
n=int(input())
lis=[int(a) for a in input().split()]
count=0
prev=False
for i in range(n):
	if lis[i]==i+1:
		if not prev:
			count+=1
			prev=True
			continue
	prev=False

print(count)
#wrong solutiuon