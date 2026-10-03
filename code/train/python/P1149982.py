N, M = map(int,input().split())
if 2*N >= M:
    print(int(M / 2))
else:
    print(int(N + (M - 2*N) // 4))
