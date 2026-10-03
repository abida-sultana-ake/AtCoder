n, m = map(int, input().split())

min_n = n
min_m = m // 2
ans = min(min_n, min_m)

if min_n < min_m:
    m -= min_n * 2
    ans += m // 4

print(ans)
