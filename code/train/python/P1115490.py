N, M = map(int, input().split())

lb, ub = 0, 10**18
K = 2 * N + M

while ub - lb > 1:
    md = (ub + lb) >> 1
    n, m = N, M
    n -= md
    if n < 0:
        m -= -n * 2
    if md * 2 <= m:
        lb = md
    else:
        ub = md

print(lb)