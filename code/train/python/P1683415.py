N,M = map(int,input().split())
edge = [[] for i in range(N)]

for i in range(M):
	a,b = map(int,input().split())
	edge[a-1].append(b-1)
	edge[b-1].append(a-1)

cnt = 0
for i in range(N):
	for j in edge[i]:
		E = [[n for n in edge[m] if not((n,m)==(i,j) or (n,m)==(j,i))] for m in range(N)]
		searched = []
		search = [i]

		while len(search) > 0:
			s = search.pop(0)
			if s in searched:
				continue
			searched.append(s)
			for v in E[s]:
				search.append(v)
		if len(searched) < N:
			cnt += 1
print(int(cnt/2))

