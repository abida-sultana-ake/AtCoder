N=int(input())

P=set()

for i in range(N):
    A=input()
    if A in P:
        P.remove(A)
    else:
        P.add(A)
        
print(len(P))