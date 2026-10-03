import sys


def inp(t): return t(sys.stdin.readline().strip())


def inpm(t): return map(t, sys.stdin.readline().split())


def inpl(t): return list(map(t, sys.stdin.readline().split()))


n = inp(int)
a = [inp(str), inp(str)]
dp = [0] * n

if a[0][0] == a[1][0]:
    dp[0] = 3
    i = 1
else:
    dp[1] = 6
    i = 2

while i < n:
    if a[0][i - 1] == a[1][i - 1]:
        if a[0][i] == a[1][i]:
            dp[i] = dp[i - 1] * 2
            i += 1
        else:
            dp[i + 1] = dp[i - 1] * 2
            i += 2
    else:
        if a[0][i] == a[1][i]:
            dp[i] = dp[i - 1]
            i += 1
        else:
            dp[i + 1] = dp[i - 1] * 3
            i += 2

print(dp[n - 1] % 1000000007)
