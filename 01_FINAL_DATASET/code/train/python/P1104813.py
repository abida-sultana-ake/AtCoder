N, M = map(int, input().split())
g = [[False]*N for _ in range(N)]
for _ in range(M):
	a, b = map(int, input().split())
	g[a-1][b-1] = True
	g[b-1][a-1] = True

stack = [[0,[1]+[0]*(N-1)]]
ans = 0
while stack:
	cur, passed = stack.pop()
	if passed == [1]*N:
		ans += 1
	else:
		for i, j in enumerate(g[cur]):
			if j and not passed[i]:
				t = passed.copy()
				t[i] = 1
				stack.append([i, t])
print(ans)