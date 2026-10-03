N, Ma, Mb = [int(i) for i in input().split()]
a, b, c = [], [], []
for i in range(N):
    a_, b_, c_ = [int(i) for i in input().split()]
    a.append(a_)
    b.append(b_)
    c.append(c_)
cost = [[float('inf')] * 401 for _ in range(401)]


def solve():
    max_a, max_b = 1, 1
    for num in range(N):
        for ca in range(max_a, -1, -1):
            for cb in range(max_b, -1, -1):
                cost[ca + a[num]][cb + b[num]] = min(cost[ca][cb] + c[num], cost[ca + a[num]][cb + b[num]])
        cost[a[num]][b[num]] = min(cost[a[num]][b[num]], c[num])
        max_a += a[num]
        max_b += b[num]


solve()
ans = float('inf')
most = ans
for i in range(1, 401):
    for n in range(1, 401):
        if i * Mb is n * Ma:
            ans = min(ans, cost[i][n])
if ans is most:
    print(-1)
else:
    print(ans)
