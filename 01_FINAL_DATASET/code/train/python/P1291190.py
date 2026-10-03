import sys

n, m, r = [int(x) for x in sys.stdin.readline().split()]
b = 0
for i in range(m):
	a = (n * (i + 1)) % m
	if a == r:
		b = 1
		break
if b == 1:
	print('YES')
else:
	print('NO')