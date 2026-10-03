import copy as c
n=int(input())
lis=[int(a) for a in input().split()]
count=0
alis=c.copy(lis)
alis=sorted(alis)
prev=False
for i in range(n):
	if lis[i]==alis[i]:
		if not prev:
			count+=1
			prev=True
			continue
	prev=False

print(count)
#wrong solutiuon