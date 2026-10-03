read = lambda: map(int, input().split())
n, a, b = read()
x = list(read())
ans = 0
for i in range(1, n):
    cur = x[i] - x[i - 1]
    ans += min(b, cur * a)
print(ans)