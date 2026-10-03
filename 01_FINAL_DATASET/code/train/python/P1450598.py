N=int(input())
a,b = map(int,input().split())
K=int(input())
P=list(map(int,input().split()))

P.append(a)
P.append(b)

A=[]

for i in range(K):
    A.append(P.count(P[i]))
    
R=max(A)

if R>=2:
    print("NO")
    
else:
    print("YES")