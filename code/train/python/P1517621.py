def Q4(x):
    N = x[0][0]
    edge = x[1:][:]

    # 隣接リストの作成
    adjacent = [0] * N
    for idx in range(N):
        adjacent[idx] = []
    for idx in range(N - 1):
        tmp = edge[idx][:]
        a = int(tmp[0]) - 1
        b = int(tmp[1]) - 1
        adjacent[a].append(b)
        adjacent[b].append(a)

    # 幅優先探索
    def bfs(N, adjacent, V):
        # 木のある頂点Vからの距離を求める
        dist = [0 for i in range(N)]  # 頂点Vからの距離
        isVisit = [False for i in range(N)]  # ある頂点が探索済か
        queue = [V - 1]  # 幅探索用キュー
        isVisit[V - 1] = True

        while queue:
            u = queue.pop()
            for p in adjacent[u]:
                if not isVisit[p]:
                    isVisit[p] = True
                    dist[p] = dist[u] + 1
                    queue.append(p)
        return dist

    Fennec_dist = bfs(N, adjacent, 1)  # フェネック(頂点1スタート)から各頂点の距離
    Snuke_dist = bfs(N, adjacent, N)  # すぬけ(頂点Nスタート)
    Fennec_point, Snuke_point = 0, 0  # 互いに、自分の色を塗れたマスの数

    for idx in range(N):
        if Fennec_dist[idx] <= Snuke_dist[idx]:
            Fennec_point += 1
        else:
            Snuke_point += 1
    if Fennec_point > Snuke_point:
        return 'Fennec'
    else:
        return 'Snuke'

import sys
n = int(input())
l = sys.stdin.readlines()
for idx in range(len(l)):
    l[idx] = l[idx].split()
    l[idx] = list(map(int, l[idx]))
lst = [[n]] + l
print(Q4(lst))