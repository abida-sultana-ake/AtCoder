N, M = map(int, input().split())

L = M//2
if N >= L:
    print(L)
else:
    print((N+L)//2)
