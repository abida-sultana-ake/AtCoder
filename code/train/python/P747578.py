import bisect
N = int(input())
hako = []
for k in range(N):
    hako.append(list(map(int, input().split())))

hako = sorted(hako, key = lambda x: (x[0],-x[1]))
hako2 = []
for k in range(N):
    hako2.append(hako[k][1])

dp = [114514] * (N+1)
for k in range(N):
    dp[bisect.bisect_left(dp, hako2[k])] = hako2[k]

ans = 0
for k in range(N+1):
    if dp[k] < 114514:
        ans = k+1
print(ans)