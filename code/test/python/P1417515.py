import numpy as np

N = int(input())

C=np.array([int(input()) for _ in range(N)])

M=np.array([np.where((c % C)==0)[0].size for c in C])

S = ((1 / M) * ((M+1) // 2)).sum()
 
print(S) 