import sys
N = int(input())
maxDist = -1
p = -1
for i in range(1, N):
	print("? {} {}".format(i, N))
	sys.stdout.flush()
	dist = int(input())
	if dist > maxDist:
		maxDist = dist
		p = i
maxDist = -1
for i in range(1, N+1):
	if i == p:
		continue
	print("? {} {}".format(i, p))
	sys.stdout.flush()
	dist = int(input())
	if dist > maxDist:
		maxDist = dist
print("! {}".format(maxDist))