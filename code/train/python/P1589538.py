N = int(input())

towns = []
for i in range(N):
    x, y = map(int, input().split())
    towns.append((i, x, y))

# x, y座標の値でソートして、隣接する街の間の道を、edgesに追加する
edges = []
for xy in [1, 2]:
    towns.sort(key=lambda t: t[xy])
    for i in range(N - 1):
        edges.append((towns[i + 1][xy] - towns[i][xy], towns[i][0], towns[i + 1][0]))

# costでソートする
edges.sort()

# 素集合データ構造
parent = [i for i in range(N)]
rank = [0 for i in range(N)]

def find(v):
    if parent[v] != v:
        parent[v] = find(parent[v])
    return parent[v]

def union(a, b):
    rootA = find(a)
    rootB = find(b)

    if rootA == rootB:
        return
    if rank[rootA] < rank[rootB]:
        parent[rootA] = rootB
    else:
        parent[rootB] = rootA
        if rank[rootA] == rank[rootB]:
            rank[rootA] += 1

# 最小全域木を求める（クラスカル法）
numTree = N
ans = 0
for cost, v1, v2 in edges:

    if find(v1) != find(v2):
        union(v1, v2)
        ans += cost
        numTree -= 1

    if numTree == 1:
        break

print(ans)
