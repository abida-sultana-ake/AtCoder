N, A, B = map(int, input().split())
a = [(a, b, c) for i in range(N) for a, b, c in [map(int, input().split())]]
inf = 10 ** 5
dp = [[None] * (N * 10 + 1) for i in range(N * 10 + 1)]
price = inf
dp[0][0] = 0
s = set(((0, 0),))

for i in range(1, N + 1):
    ai, bi, ci = a[i - 1]
    ns = s.copy()
    s = sorted(s, reverse=1)
    for _a, _b in s:
        _c = dp[_a][_b]
        na, nb = _a + ai, _b + bi
        dp[_a][_b] = _c if dp[_a][_b] is None else min(dp[_a][_b], _c)
        dp[na][nb] = ci + _c if dp[na][nb] is None else min(dp[na][nb], ci + _c)
        ns.add((na, nb))
        if (na) * B == (nb) * A:
            price = min(price, dp[na][nb])
    s = ns

print(price if price != inf else -1)