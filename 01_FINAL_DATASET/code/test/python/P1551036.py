import sys;sys.setrecursionlimit(int(1e7))

N = int(input())
ABC = [tuple(map(int, input().split())) for i in range(N-1)]
Q, K = map(int, input().split())
XY = [tuple(map(int, input().split())) for i in range(Q)]

tree = [[] for i in range(N+1)]   
depth = [None] * (N+1)

for abc in ABC:
    tree[abc[0]].append((abc[1],abc[2]))
    tree[abc[1]].append((abc[0],abc[2]))
    
def DFS(v, p, d):
    depth[v] = d
    for e in tree[v]:
        if e[0] != p:
            DFS(e[0], v, d + e[1])
            
DFS(K, 0, 0)

for x,y in XY:
    print(depth[x] + depth[y])