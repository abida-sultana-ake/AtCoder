n, x = map(int, input().split())
a = [int(i) for i in input().split()]
s = a[0]
ans = 0
for i in range(1, n):
    s += a[i]
    if s > x:
        ans += s - x
        s = max(a[i] - (s - x), 0)
    else:
        s = a[i]
print(ans)