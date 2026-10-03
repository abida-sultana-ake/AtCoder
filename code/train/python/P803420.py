N = int(input())
mat = []
for _ in range(N):
    mat.append(input())
for i in range(N):
    ans = ""
    for j in range(N):
        ans += mat[N - j - 1][i]
    print(ans)
