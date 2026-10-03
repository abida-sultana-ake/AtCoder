N, M = list(map(int, input().split()))
X, Y = list(map(int, input().split()))

A = list(map(int, input().split()))
A.reverse()
B = list(map(int, input().split()))
B.reverse()

res = 0
pre = 1e12
Ai = 0
for v in B:
    if Ai >= N:
        break

    if v + Y > pre:
        continue

    for i in range(Ai, N):
        if v >= A[i] + X:
            pre = A[i]
            res += 1
            break
        Ai += 1

print(res)
