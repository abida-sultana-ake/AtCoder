N = int(input())
K = int(input())
src = list(map(int, input().split()))

ans = 0
for i in range(N):
    d = min(src[i], K-src[i])
    ans += 2*d
print(ans)
