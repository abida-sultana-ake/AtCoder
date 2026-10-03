m, n, N = list(map(int, input().split()))
ans = N
while N >= m:
    p = N // m
    ans += p*n
    N -= p*(m-n)
print(ans)