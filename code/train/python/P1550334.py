N,K = map(int, input().split())

L = list(map(int, input().split()))

L.sort(reverse=True)
ans = 0
for i in range(K):
    ans += L[i]
print(ans)
