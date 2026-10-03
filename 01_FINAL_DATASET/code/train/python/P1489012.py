

def spaceinput():
    return list(map(int,input().split(" ")))

import numpy as np

H,W=spaceinput()
N=int(input())
a=spaceinput()

field=np.zeros([H,W])
k=0
for i in range(H):
    if i%2==0:
        for j in range(W):
            field[i][j]=k+1
            a[k]-=1
            if a[k]==0:
                k+=1

    else:
        for j in reversed(range(W)):
            field[i][j]=k+1
            a[k]-=1
            if a[k]==0:
                k+=1


for i in range(H):
    a=field[i]
    b=list(map(str,map(int,a.tolist())))
    #print(b)
    print(" ".join(b))