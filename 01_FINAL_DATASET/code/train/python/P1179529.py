N, M = list(map(int, input().split()))

lst = [[] for _ in range(N)]

for _ in range(M):
    a, b = list(map(lambda x: int(x) - 1, input().split()))
    lst[a].append(b)
    lst[b].append(a)

for l in lst:
    tmp = set()
    for x in [lst[a] for a in l]:
        for y in x:
            tmp.add(y)

    tmp = tmp.difference(l)
    print(len(tmp) - 1 if tmp else 0)
