class UnionFind:
	"""Union-Find, 
	http://www.slideshare.net/chokudai/union-find-49066733"""

	def __init__(self, N):
		self.par = [i for i in range(N)]
		self.rank = [0 for i in range(N)]

	def root(self, x):
		if(self.par[x]==x):
			return x
		else:
			self.par[x] = self.root(self.par[x])
			return self.par[x]

	def same(self, x, y):
		return self.root(x)==self.root(y)

	def unite(self, x, y):
		x = self.root(x)
		y = self.root(y)
		if x==y:
			return
		if self.rank[x]<self.rank[y]:
			self.par[x] = y
		else:
			self.par[y] = x
			if self.rank[x]==self.rank[y]:
				self.rank[x] = self.rank[x]+1
		return

N, K, L = map(lambda x:int(x), input().split())
P = [0]*K
Q = [0]*K
R = [0]*L
S = [0]*L
for i in range(K):
	P[i], Q[i] = map(lambda x:int(x), input().split())
for i in range(L):
	R[i], S[i] = map(lambda x:int(x), input().split())

uf_k = UnionFind(N)
uf_l = UnionFind(N)

for i in range(K):
	uf_k.unite(P[i]-1, Q[i]-1)
for i in range(L):
	uf_l.unite(R[i]-1, S[i]-1)

k_groups = [uf_k.root(i) for i in range(N)]
l_groups = [uf_l.root(i) for i in range(N)]

kl_groups = [(k_groups[i], l_groups[i]) for i in range(N)]
kl_groups_origin = kl_groups
kl_groups = sorted(kl_groups)

results_dict = {}

idx = 0
count = 1
pair = kl_groups[0]
for i in range(1, N):
	if kl_groups[i]==pair:
		count = count+1
	else:
		results_dict[pair] = count
		pair = kl_groups[i]
		count = 1
results_dict[pair] = count

for i in range(N):
	pair = kl_groups_origin[i]
	print(results_dict[pair], end=" ")
