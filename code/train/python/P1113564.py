"""
1 1 1
1 0 0
0 1 0
"""

import numpy as np
MOD = 10007
m = np.array([[1,1,1],
              [1,0,0],
              [0,1,0]])

r = np.identity(3, dtype=int)

N = bin(int(input()))[2:]
N = N[::-1]

for bit in N:
  if bit == '1':
    r = r.dot(m)
    r %= MOD
  m = m.dot(m)
  m %= MOD
print(r[2,2])