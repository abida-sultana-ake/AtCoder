N,K = map(int, input().split())
ans = prev = seq = 0
for i in range(N):
    now = int(input())
    if prev < now:
        seq += 1
    else:
        seq = 1
    if seq >= K:
        ans += 1
    prev = now
print(ans)
