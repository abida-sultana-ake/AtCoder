import numpy as np

A = np.array([], dtype = np.int32)
A = list(map(int, input().split()))
print(A[1] // A[0])