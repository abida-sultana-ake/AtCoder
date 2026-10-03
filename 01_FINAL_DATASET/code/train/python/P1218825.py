N, K = map(int, input().split())
A = [int(input()) for i in range(N)]
M = A[0]
t = 1
ans = 0
for i in range(N):
	if A[i] > M:
		t += 1
		M = A[i]
	else:
		t = 1
		M = A[i]
	if t == K:
		ans += 1
		t -= 1
print(ans)

