N=int(input())
A=[int(input()) for x in range(N)]

F=0
D=dict()


for i in range(N):
    B=A[i]
    if B in D.keys():
        F=F+1
    else:
        D[B]=1
        
print(F)
