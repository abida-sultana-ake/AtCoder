N = int(input())
K = int(input())
X = list(map(int, input().split()))
Total_dist = 0

#iterate through number of bals
for i in range(N):
	dist = []
	for Rtype in ['A','B']:
		if Rtype == 'A':
			dist.append(abs(X[i] - 0)*2)
		if Rtype == 'B':
			dist.append(abs(X[i] - K)*2)
	Total_dist += min(dist)

print(Total_dist)