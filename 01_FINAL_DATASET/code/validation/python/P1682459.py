H,W = map(int,input().split())
S = []
for i in range(H):
	S.append(list(input()))

ans = [['' for i in range(W)] for j in range(H)]
for i in range(H):
	for j in range(W):
		if S[i][j] == '#':
			ans[i][j] = '#'
			continue
		x = [1,1,1,0,0,-1,-1,-1]
		y = [1,0,-1,1,-1,1,0,-1]
		cnt = 0
		for k in range(len(x)):
			ii = i+x[k]
			jj = j+y[k]
			if 0 <= ii and ii < H and 0 <= jj and jj < W:
				if S[ii][jj] == '#':
					cnt += 1
		ans[i][j] = str(cnt)

for i in range(H):
	print(''.join(ans[i]))
