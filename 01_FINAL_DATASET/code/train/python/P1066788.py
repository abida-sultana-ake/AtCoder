N, A, B = [int(z) for z in input().split()]
X = [int(z) for z in input().split()]

res = 0
for i in range(N - 1):
        res += min((X[i + 1] - X[i]) * A, B)
print(res)
