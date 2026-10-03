N,M=map(int,input().split());P=[0]*N;S=2**N;C=[0]*S;C[0]=1
while M:X,Y=map(int,input().split());P[Y-1]|=1<<X-1;M-=1
for I in range(N*S):A=I//N;B=I%N;C[A|1<<B]+=C[A]*(not(A>>B&1 or A&P[B]))
print(C[-1])