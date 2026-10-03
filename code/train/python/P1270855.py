N, M = map(int, input().split())
if 2*N>M or M>4*N:
    print("-1 -1 -1")
else:
    f = M-2*N
    c = f//2
    b = f%2
    a = N-c-b
    print("%d %d %d"%(a,b,c))