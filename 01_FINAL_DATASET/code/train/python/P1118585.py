N,M = map(int, input().split())
 
tmp=M-2*N

if tmp>=0:
    print(N+int(tmp/4))
else:
    print(int(M/2))

