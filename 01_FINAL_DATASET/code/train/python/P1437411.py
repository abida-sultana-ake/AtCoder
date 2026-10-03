A,B,C,K =map(int,input().split())
S,T =map(int,input().split())

if S+T>=K:
    N=(A-C)*S+(B-C)*T
    print(N)

else:
    N=A*S+B*T
    print(N)