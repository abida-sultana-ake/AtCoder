from collections import defaultdict
import heapq


def dijkstra(s, n, graph):
    INF = 10 ** 10
    que = []    # [(最短距離, node番号)]
    heapq.heappush(que, (0, s))
    dist = [INF] * n
    dist[s] = 0
    while len(que):
        now_dist, node = heapq.heappop(que)

        if dist[node] < now_dist:
            continue

        for to, cost in graph[node]:
            new_cost = now_dist + cost
            if dist[to] > new_cost:
                dist[to] = new_cost
                heapq.heappush(que, (new_cost, to))

    return dist


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
