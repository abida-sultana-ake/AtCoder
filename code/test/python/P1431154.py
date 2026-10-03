def read(): return list(map(int, input().split()))


n = int(input())
a = read()

tot = sum(a)
for i in range(n - 1):
    a[i + 1] += a[i]

ans = 1145141919810893
for i in range(n-1):
    x = a[i]
    y = tot - x
    ans = min(ans, abs(x - y))

print(ans)
