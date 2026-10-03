x,a,b=[int(x) for x in input().split()]
if abs(a-x) > abs(b-x):
	print("B")
else:
	print('A')