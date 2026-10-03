def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def rls(): return list(input())
def pli(a): return "".join(list(map(str, a)))

import copy

N = ri()
relation = [[] for _ in range(N+1)]
dist = [[0 for i in range(N+1)] for j in range(2)]
for i in range(N-1):
    a,b = rli()
    relation[a].append(b)
    relation[b].append(a)

def dfs_visit(u):
    start = u
    rel = copy.deepcopy(relation)
    s = []
    color = [-1 for _ in range(N+1)]
    s.append(u)
    color[u] = 0
    while(s != list()):
        u = s[-1]
        try:
            v = rel[u].pop()
        except IndexError:
            dist[0 if start == 1 else 1][s[-1]] = len(s)
            s.pop()
            color[u] = 1
            continue
        if(color[v] == -1):
            color[v] = 0
            s.append(v)
 
def dfs():
    dfs_visit(1)
    dfs_visit(N)

dfs()
fe = 0
sn = 0

for i in range(1, N+1):
    if(dist[0][i] <= dist[1][i]):
        fe += 1
    else:
        sn += 1
print("Fennec" if fe > sn else "Snuke")
