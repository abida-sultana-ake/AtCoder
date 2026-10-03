N, T = [int(i) for i in input().split()]
A = []
for i in range(N):
    A.append(int(input()))

diff = [0] * (N-1)

for i in range(N-1):
    tmp = A[i+1] - A[i]
    if tmp > T:
        diff[i] = T
    else:
        diff[i] = tmp

print(sum(diff)+T)
