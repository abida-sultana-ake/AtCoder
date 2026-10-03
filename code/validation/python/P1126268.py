import numpy as np

N = int(input())

A = np.zeros((N,2))
B = np.zeros((N,2))

for i in range(N):
  A[i] = list(map(int, input().split()))
for i in range(N):
  B[i] = list(map(int, input().split()))

A_mean = np.mean(A, axis=0)
B_mean = np.mean(B, axis=0)

for i in range(2):
  A[:,i] -= A_mean[i]
  B[:,i] -= B_mean[i]

dist_A = A[:,0]**2 + A[:,1]**2
dist_B = B[:,0]**2 + B[:,1]**2

A_std = np.std(A)
B_std = np.std(B)

print(B_std/A_std)