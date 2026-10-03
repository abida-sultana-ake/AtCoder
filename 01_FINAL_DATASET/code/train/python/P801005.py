a = int(input())
k = len(str(a))
b = a**2
p = b//100**k+1
c = (a+1)**2-1
for i in range(k+1):
	i = 100**i
	ans = p
	p = (b+i-1)//i
	q = c//i
	if p > q:
		print(ans)
		break
else:
	print("error")