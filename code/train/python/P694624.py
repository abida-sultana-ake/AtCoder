N=int(input())
M=1000000007

# 各頂点が白の場合に条件を満たす部分木の数
W=[ 0 for _ in range(N)]
# 各頂点が黒の場合に条件を満たす部分木の数
B=[ 0 for _ in range(N)]

E=[[] for _ in range(N)]

def dfs( v, pre ):
	W[v]=B[v]=1
	for l in E[v]:
		if l != pre:
			dfs( l, v )
			W[v] = W[v] * (W[l] + B[l])%M
			B[v] = B[v] * (W[l])%M

for i in range(N-1):
	a,b=map( int, input().split(" ") )
	a-=1
	b-=1
	# Undirected graph
	E[a].append(b)
	E[b].append(a)

dfs(0,-1)

print((W[0]+B[0])%M)