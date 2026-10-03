n,m = map(int,input().split())
A = [[0] for i in range(n)]
for i in range(m):
	a,b = map(int,input().split())
	a,b = a - 1, b - 1
	if A[a][0] == 1:
		a = A[a][1]
	if A[b][0] == 1:
		b = A[b][1]
	if a == b:
		continue
	if len(A[a]) > len(A[b]):
		a,b = b,a
	A[b] += A[a][1:]
	A[b].append(a)
	for x in A[a][1:]:
		A[x][1] = b
	A[a] = [1,b]
cnt = 0
for a in A:
	if a[0] == 0:
		cnt += 1
print(cnt - 1)