nums = [int(x) for x in input().split()]
N,M = nums[0],nums[1]

right = M-2*N
if right < 0:
	print(-1,-1,-1)
	exit(0)

c = right // 2
b = right % 2
a = N - b - c

if a >= 0:
	print(a,b,c)
else:
	print(-1,-1,-1)