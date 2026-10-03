N, M = map(int, input().split())
g = [[] for i in range(N)]
for i in range(M):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    g[a].append(b)
    g[b].append(a)


memo = {}
all_use = (1 << N) - 1


def rec(v, use):
    if use == all_use:
        return 1

    key = (v, use)
    if key in memo:
        return memo[key]

    res = 0
    for u in g[v]:
        if (use >> u) & 1 == 1:
            continue

        use = use ^ (1 << u)
        res += rec(u, use)
        use = use ^ (1 << u)

    memo[key] = res
    return res


print(rec(0, 1))