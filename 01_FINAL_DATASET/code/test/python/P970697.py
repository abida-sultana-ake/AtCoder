a = (input().split())

for i in range(len(a)):
	a[i]=int(a[i])
a.sort()
if a[0]+a[1]==a[2]:
	print("Yes")
else:
	print("No")