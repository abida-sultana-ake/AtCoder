n, X = map(int, input().split())
A = input().split()
A.reverse()

x = format(X, "b").zfill(n)
ans = 0
for i in range(n):
    ans += int(x[i]) * int(A[i])

print(ans)