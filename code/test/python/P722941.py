N, K = map(int, input().split())
a = list(map(int, input().split()))
s = sum(a[0:K])
ans = s

for p in range(N-K):
    s -= a[p]
    s += a[p+K]
    ans += s

print(ans)