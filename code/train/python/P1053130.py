N, x = map(int, input().split())
A = list(map(int, input().split()))

result = 0
for i in range(N):
	result = result+max(0, A[i]-x)
	A[i] = min(x, A[i])

for i in range(N-1):
	if A[i]+A[i+1]<=x:
		continue
	result = result+A[i]+A[i+1]-x
	A[i+1] = A[i+1]-(A[i]+A[i+1]-x)

print(result)