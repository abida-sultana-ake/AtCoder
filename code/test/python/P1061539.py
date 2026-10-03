a, b, c = input().split()

if a!=b and b!=c and a!=c:
	print(3)
elif a==b and b==c:
	print(1)
else:
	print(2)
