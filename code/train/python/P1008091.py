N, x = map(int, input().split())
A = list(map(int, input().split()))
ans = 0
for i in range(1, N):
    if A[i-1] + A[i] > x:
        sub = (A[i-1] + A[i]) - x
        if A[i] < sub:
            sub = sub - A[i]
            ans += A[i]
            A[i] = 0
            A[i-1] -= sub
        else:
            A[i] -= sub
        ans += sub
print(ans)
