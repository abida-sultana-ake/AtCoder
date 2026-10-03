from bisect import bisect_left

N = int(input())

#読み取り
data = [int(input()) for _ in range(N)]

dp = [float('inf')]

for ai in data:
    if ai > dp[-1]:
        dp.append(ai)
    else:
        j = bisect_left(dp, ai)
        dp[j] = ai

print(N-len(dp))
