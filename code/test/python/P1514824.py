from collections import defaultdict
import heapq

# sからすべての頂点への最小距離を求める O(|E| log |V|)
# s: startノード
# n: 頂点数
# graph: graph[node] = [(to1, cost1), (to2, cost2), ...]
def dijkstra(s: int, n: int, graph: dict) -> list:
    INF = 10 ** 10
    que = []    # [(最短距離, node番号)]
    heapq.heappush(que, (0, s))
    min_dist_list = [INF] * n
    min_dist_list[s] = 0
    while que:
        now_dist, node = heapq.heappop(que)

        if min_dist_list[node] < now_dist:
            continue

        for to, dist in graph[node]:
            new_dist = now_dist + dist
            if min_dist_list[to] > new_dist:
                min_dist_list[to] = new_dist
                heapq.heappush(que, (new_dist, to))

    return min_dist_list


def main():
    N, M, T = map(int, input().split())
    values = list(map(int, input().split()))
    graph1 = defaultdict(list)
    graph2 = defaultdict(list)
    for _ in range(M):
        a, b, c = map(int, input().split())
        a, b = a - 1, b - 1
        graph1[a].append((b, c))
        graph2[b].append((a, c))

    dist1 = dijkstra(0, N, graph1)
    dist2 = dijkstra(0, N, graph2)

    ans = 0
    for i in range(len(dist1)):
        t = T - (dist1[i] + dist2[i])
        if t >= 0:
            ans = max(ans, t * values[i])
    print(ans)


if __name__ == '__main__':
    main()
