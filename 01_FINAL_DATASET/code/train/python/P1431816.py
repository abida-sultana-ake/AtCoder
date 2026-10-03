import queue


class Edge:
    def __init__(self, to, cost):
        self.to = to
        self.cost = cost


class P:
    def __init__(self, distance, v):
        self.distance = distance
        self.v = v


# def dijkstra(_s):
#     que = queue.Queue()
#     global d
#     d = [float("inf") for i in range(N)]
#     d[_s] = 0
#     que.put(P(0, _s))
#
#     while not que.empty():
#         p = que.get()
#         v = p.v
#         if d[v] < p.distance:
#             continue
#         for i in range(0, len(G[v])):
#             e = G[v][i]
#             if d[e.to] > d[v] + e.cost:
#                 d[e.to] = d[v] + e.cost
#                 que.put(P(d[e.to], e.to))

def bfs(_s):
    q = queue.Queue()
    global d
    d = [float("inf") for i in range(N)]
    used = [False for i in range(N)]
    used[_s] = True
    d[_s] = 0
    q.put(_s)

    while not q.empty():
        p = q.get()
        for i in range(0, len(G[p])):
            if not used[G[p][i]]:
                used[G[p][i]] = True
                d[G[p][i]] = d[p] + 1
                q.put(G[p][i])


if __name__ == '__main__':
    N = int(input())
    a = []
    b = []
    for i in range(N - 1):
        tmp_a, tmp_b = list(map(int, input().split()))
        a.append(tmp_a - 1)
        b.append(tmp_b - 1)

    G = [[] for i in range(N)]
    for i in range(0, N - 1):
        # G[a[i]].append(Edge(b[i], 1))
        # G[b[i]].append(Edge(a[i], 1))
        G[a[i]].append(b[i])
        G[b[i]].append(a[i])

    # Fennec
    global d
    bfs(0)
    Fennec_d = d

    # sunuke
    bfs(N - 1)
    sunuke_d = d

    for i in range(0, len(Fennec_d)):
        if Fennec_d[i] <= sunuke_d[i]:
            sunuke_d[i] = -1
        else:
            Fennec_d[i] = -1

    # print(Fennec_d)
    # print(sunuke_d)

    Fennec_count = 0
    sunuke_count = 0
    for i in range(0, len(Fennec_d)):
        if Fennec_d[i] < 0:
            sunuke_count += 1
        else:
            Fennec_count += 1

    if sunuke_count < Fennec_count:
        print("Fennec")
    else:
        print("Snuke")
