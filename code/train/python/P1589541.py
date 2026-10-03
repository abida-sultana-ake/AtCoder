N = int(input())

towns = []
for i in range(N):
    x, y = map(int, input().split())
    towns.append((i, x, y))

# x, y座標の値でソートして、隣接する街の間の道を、隣接リストadjに追加する
adj = [[] for i in range(N)]
for xy in [1, 2]:
    towns.sort(key=lambda t: t[xy])
    for i in range(N - 1):
        t1 = towns[i][0]
        t2 = towns[i + 1][0]
        cost = towns[i + 1][xy] - towns[i][xy]
        adj[t1].append((t2, cost))
        adj[t2].append((t1, cost))

# 最小全域木を求める（プリム法）
import heapq
pq = []
heapq.heappush(pq, (0, 0))

done = set()
ans = 0
while pq:
    cost, v_now = heapq.heappop(pq)

    if v_now in done:
        continue

    ans += cost
    done.add(v_now)

    if len(done) == N:
        break

    for v, c in adj[v_now]:
        if v not in done:
            heapq.heappush(pq, (c, v))

print(ans)
