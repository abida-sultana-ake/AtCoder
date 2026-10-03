a,b,c = map(int,input().split())
if a == b and b==c:
	print(1)
elif a== b and a != c:
	print(2)
elif b== c and b != a:
	print(2)
elif c== a and c != b:
	print(2)
else:
	print(3)