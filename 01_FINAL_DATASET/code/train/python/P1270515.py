N, D, K = map(int, input().split())
L = []
R = []

for i in range(D):
	l, r = map(int, input().split())
	L.append(l)
	R.append(r)

for i in range(K):
	s, t = map(int, input().split())
	if s < t:
		for j in range(D):
			if L[j] <= s:
				s = max(s, R[j])
			if s >= t:
				print(j+1)
				break
	else:
		for j in range(D):
			if R[j] >= s:
				s = min(s, L[j])
			if s <= t:
				print(j+1)
				break
