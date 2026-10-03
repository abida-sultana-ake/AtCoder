
from collections import defaultdict, deque


def bfs(graph, n, start):
    q = deque([start])

    dists = [-1] * (n+1)
    dists[start] = 0

    while q:
        cur = q.pop()

        for neigh, d in graph[cur].items():
            if dists[neigh] == -1:
                q.appendleft(neigh)
                dists[neigh] = dists[cur] + d

    return dists


def main():
    n = int(input())

    graph = defaultdict(dict)

    for _ in range(n-1):
        a, b, c = (int(x) for x in input().split())
        graph[a][b] = c
        graph[b][a] = c

    q, k = (int(x) for x in input().split())

    dists = bfs(graph, n, k)

    for _ in range(q):
        start, end = (int(x) for x in input().split())
        print(dists[start] + dists[end])


if __name__ == "__main__":
    main()
