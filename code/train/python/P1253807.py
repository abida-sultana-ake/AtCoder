def f1():
	L.sort(key = (lambda x: - x[1]//(x[0] - w1 + 40)))
	ans = 0
	w2 = 0
	i = 0
	while i < N:
		w2 = w2 + L[i][0]
		if w2 > W:
			break
		ans = ans + L[i][1]
		i = i + 1
	
	return ans
	
def f3():
	L.sort(key = (lambda x: - x[1]//x[0]))
	ans = 0
	w2 = 0
	i = 0
	while i < N:
		w2 = w2 + L[i][0]
		if w2 > W:
			break
		ans = ans + L[i][1]
		i = i + 1
	
	return ans
def f2():
	dp = [[0] * (W + 1) for i in range(N + 1)]
	for n in range(1,N + 1):
		w,v = L[n - 1]
		if w > W:
			continue
		for m in range(w):
			dp[n][m] = dp[n - 1][m]
		for m in range(w,W + 1):
			dp[n][m] = max(dp[n - 1][m - w] + v, dp[n - 1][m])
	return max(dp[-1])
	
N,W = map(int,input().split())
L = [list(map(int,input().split())) for i in range(N)]
w1 = L[0][0]
if w1 > 10000000:
	print(f1())
elif W > 10000000:
	print(f3())
else:
	print(f2())
