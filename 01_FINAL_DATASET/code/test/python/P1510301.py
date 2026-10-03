# Transit Tree Path

N = int(input())
p =[]
for i in range(N-1):
    p.append(list(map(int, input().split())))
Q,K = list(map(int, input().split()))
r = []
for i in range(Q):
    r.append(list(map(int, input().split())))

#隣接行列
adj = [[] for i in range(N+1)]
for pi in p:
    adj[pi[0]].append((pi[1],pi[2]))
    adj[pi[1]].append((pi[0],pi[2]))
adj


from collections import deque #decue使う
dist = [-1]*(N+1) #距離リスト
dist[K] = 0 #頂点Kからの距離は0
d = deque() #探索済みのリスト
d.append(K)
while len(d):
    pp = d.popleft() #探索中の頂点
    for q,c in adj[pp]:
        if dist[q] != -1:
            continue
        dist[q] = dist[pp]+c
        d.append(q)
for i in range(Q):
    x, y = r[i]
    print(dist[x]+dist[y])