input()
a=[]
for i in input().split():
	a.append(int(i))

maxp = 0
minp = 10000000000000
maxval=0
c=0
for i in range(len(a)):
	if a[i]<minp:
		minp=a[i]
	val=a[i]-minp
	if val>maxval:
		maxval=val
		c=1
	elif val==maxval:
		c+=1

print(c)