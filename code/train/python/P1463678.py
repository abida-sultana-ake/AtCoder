c = [1,2,4,8,16,32,64]
N = int(input())

if 1 <= N < 2:
	print(c[0])
elif 2 <= N < 4:
	print(c[1])
elif 4 <= N < 8:
	print(c[2])
elif 8 <= N < 16:
	print(c[3])
elif 16 <= N < 32:
	print(c[4])
elif 32 <= N < 64:
	print(c[5])
elif 64 <= N:
	print(c[6])