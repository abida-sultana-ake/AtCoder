from collections import Counter
N = int(input())
A = Counter([int(i) for i in input().split()])
c = 0
for i in A:
	if not A[i] % 2:
		c += 1
print(len(A)-c%2)
