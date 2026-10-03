n = int(input())
k = int(input())
a = (n-1)//2
if n % 2 == 0:
	a += 1
if k <= a:
	print("YES")
else:
	print("NO")