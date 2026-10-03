N,M=[int(x) for x in input().split()]
if N >= M:
    Scc = M//2
elif N < M and (M - 2*N >=4):
    Scc = N + (M-2*N)//4
else:
    Scc = N
print(Scc)