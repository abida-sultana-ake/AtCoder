# coding: utf-8

n, m = list(map(int, input().split()))

inlist = []
for i in range(m):
	inlist.append(list(map(int, input().split())))

graph = [[0 for i in range(n)] for j in range(n)]

for i in inlist:
	graph[i[0]-1][i[1]-1] = 1
	graph[i[1]-1][i[0]-1] = 1

visited = []
visited.append(0)
count = 0
def dfs(cur):
	if len(visited) == n:
		global count
		count += 1
		return
	for i in range(n):
		if graph[cur][i] == 1 and i not in visited:
			visited.append(i)
			dfs(i)
			visited.pop()
	return

dfs(0)

print(count)
