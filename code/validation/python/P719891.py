
import numpy as np

a = np.array([ int(c) for c in raw_input().split()])
N = a[0]
Q = a[1]
RET = np.zeros(N,np.int)

for no_meaning in range(Q):
	a = np.array([ int(c) for c in raw_input().split()],np.int)
	L = a[0] - 1
	R = a[1]
	T = a[2]
	
	RET[L:R] = T

for i in range(N):
	print ( RET[i] )