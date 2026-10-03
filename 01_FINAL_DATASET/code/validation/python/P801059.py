norm = 2 * (10 ** 12)
a, k = map(int, input().split())
ans = 0
if k == 0 and a < norm:
    ans = norm - a
else:
    while a < norm:
        a += a * k + 1
        ans += 1
print(ans)