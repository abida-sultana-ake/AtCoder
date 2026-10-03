N,A,B = [int(i) for i in input().split()]

v = [int(i) for i in input().split()]
v.sort(reverse=True)

max_average = sum(v[:A]) / A

C = [[0]*51 for i in range(51)]
for i in range(N+1):
    for j in range(i+1):
        if j == 0 or i == 0:
            C[i][j] = 1
        else:
            C[i][j] = C[i-1][j-1] + C[i-1][j]

ans = 0
cnt = 0
if v[0] == v[A-1]:
    for i in range(N):
        if v[i] == v[0]:
            cnt += 1
    for i in range(A, B+1):
        ans += C[cnt][i]
else:
    included = 0
    for i in range(N):
        if v[i] == v[A-1]:
            cnt += 1
            if i < A:
                included += 1
    ans += C[cnt][included]

print(max_average)
print(ans)