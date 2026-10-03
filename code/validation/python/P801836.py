F=lambda:map(int,input().split());N,M=F();P=[0]*N;C=[0]*2**N;C[0]=1
while M:X,Y=F();P[Y-1]|=1<<X-1;M-=1
for I in range(N*2**N):A=I//N;B=I%N;C[A|1<<B]+=C[A]*(not(A>>B&1 or A&P[B]))
print(C[-1])