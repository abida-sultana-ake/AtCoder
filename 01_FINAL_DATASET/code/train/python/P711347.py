import sys
import copy
N = int(input())
I = [list(input()) for i in range(N)]
A = copy.deepcopy(I)
for i in range(N):
    for j in range(N):
        A[j][i] = I[i][j]
for i in range(N):
    for j in range(N):
        sys.stdout.write(A[i][N-j-1])
    print()
