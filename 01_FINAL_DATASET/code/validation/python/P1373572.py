MOD = int(1e9) + 7


def f(n):
    ans = 1
    for i in range(1, n + 1):
        ans *= i
        ans %= MOD
    return ans


N, M = map(int, input().split())

if abs(N - M) >= 2:
    print(0)
    exit()

maxv = max(N, M)
minv = min(N, M)

if maxv == minv:
    ans = f(maxv)
    ans *= f(minv)
    ans *= 2
    ans %= MOD
    print(ans)
    exit()

ans = f(maxv)
ans *= f(minv)
ans %= MOD
print(ans)
