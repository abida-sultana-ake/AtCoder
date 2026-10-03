# coding: utf-8;

import heapq

def dijkstras(graph):
    cost = [10 ** 9 for _ in range(len(graph))]
    start = 0
    cost[start] = 0
    queue = [(cost[start], start)]

    while queue:
        edge_from_cost, edge_from = heapq.heappop(queue)
        if cost[edge_from] < edge_from_cost: continue
        for edge_to, edge_to_cost in graph[edge_from]:
            if cost[edge_to] > edge_from_cost + edge_to_cost:
                cost[edge_to] = cost[edge_from] + edge_to_cost
                heapq.heappush(queue, (cost[edge_to], edge_to))

    return cost

def treasure_hant(n, m, t, th, graph, reverse_graph):
    cost = dijkstras(graph)
    reverse_cost = dijkstras(reverse_graph)

    max_money = 0

    for i in range(n):
        m = (t - cost[i] - reverse_cost[i]) * th[i]
        if m > max_money:
            max_money = m

    return max_money

def main():
    n, m, t = map(int, input().split())
    th =[int(i) for i in input().split()]
    graph = [[] for _ in range(n)]
    reverse_graph = [[] for _ in range(n)]

    for i in range(m):
        a, b, c = map(int, input().split())
        a -= 1
        b -= 1
        graph[a].append((b, c))
        reverse_graph[b].append((a, c))

    graph = tuple(tuple(edge) for edge in graph)
    reverse_graph = tuple(tuple(edge) for edge in reverse_graph)

    print(treasure_hant(n, m, t, th, graph, reverse_graph))

if __name__ == '__main__':
    main()
