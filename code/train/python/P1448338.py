
from collections import Counter

N = int(input())
graph =[[] for _ in range(N + 1)]
visited = [None] * (N + 1)

for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

v = 1
adv_v = N
update = True
labels = [0, 1]
vs = [v, adv_v]
prev_vs = [-1, -1]
visited[1] = 0
visited[N] = 1
while update:
    update = False
    next_cand = []

    for label, v, prev_v in zip(labels, vs, prev_vs):
        for next_v in graph[v]:
            if next_v == prev_v:
                continue
            if (visited[next_v] is None):
                update = True
                next_cand.append((next_v, label, v))

    vs = []
    labels = []
    prev_vs = []
    for next_v, label, prev_v in next_cand:
        if visited[next_v] is None:
            visited[next_v] = label
            vs.append(next_v)
            prev_vs.append(prev_v)
            labels.append(label)


c = Counter(visited)
if c[0] > c[1]:
    print("Fennec")
else:
    print("Snuke")
