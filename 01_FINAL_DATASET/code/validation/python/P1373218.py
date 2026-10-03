n, m = map(int, input().split())
if m<n-1 or n+1<m:
    print(0)
    exit()
MOD = 10**9+7

ans = 1
for i in range(2, n+1):
    ans = (ans * i)%MOD
for i in range(2, m+1):
    ans = (ans * i)%MOD
if n == m:
    ans = (ans * 2)%MOD
print(ans)