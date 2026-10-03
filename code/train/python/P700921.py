def rec(v, prev, can):
    if memo[v][can] > 0:
        return memo[v][can]
    use, notuse = can, 1
    for child in E[v]:
        if child != prev:
            notuse = (notuse * rec(child, v, 1)) % Mod
            if can:
                use = (use * rec(child, v, 0)) % Mod
    res = memo[v][can] = (use + notuse) % Mod
    return res


Mod = 10 ** 9 + 7
N = int(input())
E = [[] for i in range(N)]
memo = [[0, 0] for i in range(N)]

for i in range(N - 1):
    a, b = map(int, input().split())
    E[a - 1].append(b - 1)
    E[b - 1].append(a - 1)
print(rec(0, -1, 1))
