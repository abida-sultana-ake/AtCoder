l = input().split()
x = float(l[0])
a = float(l[1])
b = float(l[2])


if abs(x-a) < abs(x-b):
	print("A")
else:
	print("B")