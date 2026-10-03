N = int(input())

adj = [[] for i in range(N)]
for i in range(N - 1):
    a, b = map(int, input().split())
    adj[-a].append(b)
    adj[-b].append(a)

def calc_dist(K):
    # dist[-i]:頂点Kから頂点iまでの距離
    dist = [-1 for i in range(N)]
    dist[-K] = 0

    # 深さ優先探索（スタック）
    from collections import deque
    stack = deque()
    stack.append(K)

    while stack:
        v = stack.pop()
        for nxt in adj[-v]:
            if dist[-nxt] == -1:
                dist[-nxt] = dist[-v] + 1
                stack.append(nxt)

    return dist

dist1 = calc_dist(1)
distN = calc_dist(N)

Fennec = 0
Snuke = 0
for v in range(N):
    if dist1[-v] <= distN[-v]:
        Fennec += 1
    else:
        Snuke += 1

if Fennec > Snuke:
    print('Fennec')
else:
    print('Snuke')
