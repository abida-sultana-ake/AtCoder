class UnionFind:
    def __init__(self, size):
        self.parents = list(range(size))

    def find(self, i):
        ret = i
        path = []
        while self.parents[ret]!=ret:
            path.append(ret)
            ret = self.parents[ret]
        for p in path:
            self.parents[p] = ret
        return ret

    def union(self, i, j):
        self.parents[self.find(i)] = j

n = int(input())
xys = [(tuple(map(int, input().split())), i) for i in range(n)]

sortx = sorted(xys, key=lambda xy: xy[0][0])
roadsx = [(sortx[i][0][0]-sortx[i-1][0][0], sortx[i][1], sortx[i-1][1]) for i in range(1, n)]
sorty = sorted(xys, key=lambda xy: xy[0][1])
roadsy = [(sorty[i][0][1]-sorty[i-1][0][1], sorty[i][1], sorty[i-1][1]) for i in range(1, n)]
roads = roadsx + roadsy
roads.sort(key=lambda x:x[0])

ctr = 1
ans = 0
uf = UnionFind(n)
for road in roads:
    if ctr >= n:
        break
    cost, i1, i2 = road
    if uf.find(i1) != uf.find(i2):
        ans += cost
        ctr += 1
        uf.union(i1, i2)

print(ans)