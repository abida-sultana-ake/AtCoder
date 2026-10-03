n, W = [int(_) for _ in raw_input().split()]

wvs = [[int(_) for _ in raw_input().split()] for i in xrange(n)]

p = {0: 0}

for w, v in wvs:
    for d, dv in p.items():
        p[d + w] = max(p.get(d + w, 0), dv + v)
    m = -1
    for d, dv in sorted(p.items()):
        if dv <= m:
            del p[d]
            continue
        m = max(m, dv)

ans = 0
for d, dv in sorted(p.items()):
    if d > W:
        break
    ans = dv

print(ans)