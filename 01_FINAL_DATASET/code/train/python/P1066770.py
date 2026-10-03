n, a, b = map(int, input().split())
x = list(map(int, input().split()))

ans = 0

for i in range(n - 1):
    c = (x[i + 1] - x[i]) * a
    ans += min(c, b)

print(ans)