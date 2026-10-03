N, x = map(int, input().split())
a = list(map(int, input().split()))
a.insert(0, 0)
a.append(0)

ans = 0

for i in range(0, N + 1):
    d = a[i] + a[i + 1] - x
    if d > 0:
        ans += d
        if a[i + 1] > d:
            a[i + 1] -= d
        else:
            a[i] -= d - a[i + 1]
            a[i + 1] = 0

print(ans)
