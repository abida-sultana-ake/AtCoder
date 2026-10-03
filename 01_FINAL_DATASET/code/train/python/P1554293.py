N, M = map(int, input().split())

if (M < 2*N) or (4*N < M):
    print("-1 -1 -1")
else:
    n = M - 2 * N
    if n <= N:
        li = [N-n, n, 0]
    else:
        li = [0, 2*N-n, n-N]
    for i in li:
        print(i, end=" ")