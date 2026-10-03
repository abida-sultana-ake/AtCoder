A, K = map(int, input().split())
c = 0
INF = 2000000000000

def solve(A, c):
    if A >= INF:
        return c
    if A < INF:
        A += 1 + (A * K)
        c += 1
        return solve(A, c)
if K != 0:
    print(solve(A, 0))
else:
    print(INF-A)
