N,T = map(int,input().split())
A=[int(input()) for i in range(N)]

G=T

for i in range(N-1):
    if A[i+1]-A[i]<=T and A[i]-A[i-1]<=T:
        G=G+A[i+1]-A[i]
    elif A[i+1]-A[i]>=T:
        G=G+T
    elif A[i+1]-A[i]<T:
        G=G+A[i+1]-A[i]
        
print(G)