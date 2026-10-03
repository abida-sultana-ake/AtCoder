N,K,L = map(int, input().split())

road_parent = list(range(N))
road_rank = [0] * N
train_parent = list(range(N))
train_rank = [0] * N

def Find(parent, i):
	if parent[i] == i:
		return i
	else:
		parent[i] = Find(parent, parent[i])
		return parent[i]

def Union(parent, rank, i, j):
	i_root = Find(parent, i)
	j_root = Find(parent, j)
	if rank[i_root] > rank[j_root]:
		parent[j_root] = i_root
	elif rank[i_root] < rank[j_root]:
		parent[i_root] = j_root
	elif i_root != j_root:
		parent[j_root] = i_root
		rank[i_root] += 1

for cnt in range(K):
	i,j = map(int, input().split())
	Union(road_parent, road_rank, i-1, j-1)

for cnt in range(L):
	i,j = map(int, input().split())
	Union(train_parent, train_rank, i-1, j-1)

from collections import defaultdict

counter = defaultdict(int)
for i in range(N):
	counter[(Find(road_parent, i), Find(train_parent, i))] += 1

print(' '.join(str(counter[(Find(road_parent, i), Find(train_parent, i))]) for i in range(N)))