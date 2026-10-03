import numpy as np
 
N = int(input())
 
A = np.zeros((N,2))
B = np.zeros((N,2))
 
for i in range(N):
  A[i] = list(map(int, input().split()))
for i in range(N):
  B[i] = list(map(int, input().split()))
 
A -= np.mean(A, axis=0, keepdims=True)
B -= np.mean(B, axis=0, keepdims=True)
 
dist_A = np.max(np.sqrt(A[:,0]**2 + A[:,1]**2))
dist_B = np.max(np.sqrt(B[:,0]**2 + B[:,1]**2))
 
print(dist_B/dist_A)