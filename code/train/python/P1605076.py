import numpy as np
s_1,s_2,a,b,c,d = list(map(int,input().split()))

a -= s_1
c -= s_1

b -= s_2
d -= s_2

B = [a,b]
C = [c,d]

print(abs(np.cross(B,C)/2))