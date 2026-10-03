import numpy as np
N = int(input())
a = np.array(list(map(int, input().split())))

c = np.array([0] * 8)

a //= 400

for i in range(8):
    num = np.sum(a == i)
    c[i] = num
red = np.sum(a >= 8)


mincol = np.sum(c != 0)
maxcol = mincol + red
if mincol == 0:
    mincol = 1

print(mincol, maxcol)



    
