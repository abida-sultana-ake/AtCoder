import sys
sys.setrecursionlimit(sys.getrecursionlimit()*1000)

input = sys.stdin.readline
N = int(input())
tree = [[] for _ in range(N+1)]
for _ in range(N-1):
    a, b = map(int,input().split())
    tree[a].append((b,1))
    tree[b].append((a,1))

depth = [None]*(N+1)
def DFS(v,p,d):
    depth[v] = d
    for e in tree[v]:
        if e[0] != p:
            DFS(e[0], v, d + e[1])
DFS(1,0,0)

depthN = [None]*(N+1)
def DFSN(v,p,d):
    depthN[v] = d
    for e in tree[v]:
        if e[0] != p:
            DFSN(e[0], v, d + e[1])
DFSN(N,0,0)

black = 0
for i in range(1,N):
    if depth[i] <= depthN[i]:
        black += 1

if black > N/2:
    print("Fennec")
else:
    print("Snuke")

