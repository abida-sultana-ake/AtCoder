S=list(input())

L=len(S)

H=""
V=""
A=1
B=1

for i in range(1,L):
    if S[i]==S[i-1]:
        #V=S[i]
        A=A+1
    elif S[i]!=S[i-1]:
        H=H+S[i-1]+str(A)
        A = 1

for x in reversed(range(1,L)):
    if S[x]==S[x-1]:
        B=B+1
    elif S[x]!=S[x-1]:
        break

H=H+S[-1]+str(B)
        
print(H)