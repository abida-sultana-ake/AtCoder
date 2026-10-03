
def f(m, r):
    connmap = [[] for _ in range(m + 1)]
    for _ in range(r):
        a, b = map(int, input().split())
        connmap[a].append(b)
        connmap[b].append(a)
    group = [0] * (m + 1)
    num = 0
    for i in range(1, m + 1):
        if group[i] > 0:
            continue
        num += 1
        group[i] = num
        for j in connmap[i]:
            group[j] = num
        bfs = connmap[i]
        while len(bfs) > 0:
            tmp = []
            for j in bfs:
                for k in connmap[j]:
                    if group[k] > 0:
                        continue
                    group[k] = num
                    tmp.append(k)
            bfs = tmp
    return group

n, k, l = map(int, input().split())

road = f(n, k)
rail = f(n, l)

count = {}

for i in range(1, n + 1):
    key = '{0} {1}'.format(road[i], rail[i])
    if key in count:
        count[key] += 1
    else:
        count[key] = 1
    
for i in range(1, n + 1):
    key = '{0} {1}'.format(road[i], rail[i])
    print(count[key], end=' ' if i < n else '')
print()

