N = int(input())
T = [0]*N
A = [0]*N
for i in range(N):
    T[i],A[i] = map(int,input().split())

def aa(a,t,na,nt):
    c = max( (1+(a-1)//na,1+(t-1)//nt) )
    return (na*c,nt*c)
t = T[0]
a = A[0]
for i in range(N):
    a,t = aa(a,t,A[i],T[i])
print(t+a)
