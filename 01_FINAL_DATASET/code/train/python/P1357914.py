N, A = map(int, input().split())
a = [int(n) for n in input().split()]
dp = [[[0]*2501 for i in "0"*51] for j in "0"*51]
dp[0][0][0] = 1

ans = 0
for i in range(N):
    for cards in range(i+1):
        for total in range(cards*50+1):
            nc, nt = cards+1, total+a[i]
            n = dp[i][cards][total]
            if n > 0:
                dp[i+1][nc][nt] += n
                dp[i+1][cards][total] += n
                if nc*A == nt:
                    ans += n

print(ans)