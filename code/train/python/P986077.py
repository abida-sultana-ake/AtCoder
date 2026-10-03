n = int(input())
ans = 100000
for i in range(1, n+1):
    a = abs(i-int(n/i))+(n-i*int(n/i))
    ans = min(ans, a)
print(ans)

