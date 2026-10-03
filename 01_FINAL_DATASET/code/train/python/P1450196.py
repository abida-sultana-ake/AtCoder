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

H=H+S[L-1]+str(A)

print(H)