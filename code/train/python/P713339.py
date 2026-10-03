# def makelist(n, m):
# 	return [[0 for i in range(m)] for j in range(n)]
import math
PI = math.pi

def ensui(r, h):
	return r * r * PI * h * (1/3)

N, Q = map(int, input().split())

X = [0]*N
R = [0]*N
H = [0]*N
area = [0]*N
for i in range(N):
	X[i], R[i], H[i] = map(int, input().split())

# for t in area:
# 	print(t)

for k in range(Q):
	ans = 0
	A, B = map(int, input().split())
	for i in range(N):
		l = max(A, X[i])
		r = min(B, X[i]+H[i])
		if l < r:
			res = 0
			hankei = R[i]
			if l != X[i]:
				tmp = H[i] - (l - X[i])
				res += ensui(R[i] * (tmp / H[i]), tmp)
			else:
				res += ensui(R[i], H[i])
			if r != X[i]+H[i]:
				tmp2 = X[i] + H[i] - r
				res -= ensui(R[i] * (tmp2/H[i]), tmp2)
			ans += res
	print(ans)
