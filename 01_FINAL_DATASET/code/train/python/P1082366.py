x = int(input())
if x <= 6:
	print(1)
elif  x <= 11:
	print(2)
else:
	a,b = divmod(x,11)
	if b == 0:
		print(a*2)
	elif 1 <= b <= 6:
		print(a*2+1)
	else:
		print(a*2+2)