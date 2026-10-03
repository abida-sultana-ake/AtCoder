N = int(input())

if N == 1:
	print(1)
elif N < 4:
	print(2)
elif N < 8:
	print(4)
elif N < 16:
	print(8)
elif N < 32:
	print(16)	
elif N < 64:
	print(32)
else:
	print(64)