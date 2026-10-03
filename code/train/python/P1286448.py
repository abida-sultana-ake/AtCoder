import sys
r = [0]*100000
n,k = [int(x) for x in sys.stdin.readline().split()]
for i in range(n):
	a, b = [int(x) for x in sys.stdin.readline().split()]
	r[a-1] += b
c = 0
for i,j in enumerate(r):
	c += j
	if c >= k:
		print(i+1)
		break