n=int(input())
l=[int(x) for x in input().split()]

l1=[0]*(100002)

for i in range(n):
	l1[l[i]]+=1
	l1[l[i]+1]+=1
	l1[l[i]-1]+=1

print(max(l1))