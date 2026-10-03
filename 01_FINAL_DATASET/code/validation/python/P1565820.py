N = int(input())
A = [int(x) for x in input().split()]

A.sort()

for i in range(N - 1):
    if A[i] == A[i + 1]:
        A[i + 1] = 0
    else:
        A[i] = 0

A[N - 1] = 0

A.sort()
A.reverse()
print(A[0] * A[1])
