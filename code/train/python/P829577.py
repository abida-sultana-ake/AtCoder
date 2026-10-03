n = int(input())
a = [int(x) for x in input().split()]
dp = [0]
for i in range(1, len(a)):
     dp.append(min(dp[i-1]+abs(a[i]-a[i-1]), dp[i-2]+abs(a[i]-a[i-2]) if i>1 else 1000000))
print(dp[-1])