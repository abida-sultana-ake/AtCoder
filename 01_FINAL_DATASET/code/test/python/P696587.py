import numpy as N
A = N.matrix([[1,1], [1,0]])
B = N.matrix([[1],[1]])
K = int(input())
R = (A ** K) * B
a, b = int(R[0][0]), int(R[1][0])
print(a,b)
