import itertools

n, m = map(int, input().split())
connect = [set() for _ in range(n)]

for _ in range(m):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    connect[a].add(b)
    connect[b].add(a)

ans = 0
for order in itertools.permutations(list(range(1,n))):
    ok = True
    now = 0
    for to in order:
        if to not in connect[now]:
            ok = False
            break
        now = to

    if ok:
        ans += 1

print(ans)