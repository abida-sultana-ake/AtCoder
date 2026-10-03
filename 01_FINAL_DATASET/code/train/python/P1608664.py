N, A, B = list(map(int, input().split()))
S = [int(input()) for i in range(N)]
Smax = max(S)
Smin = min(S)
if Smax == Smin:
    print(-1)
else:
    Smean = sum(S) / N
    P = B / abs(Smax - Smin)
    Q = A - P * Smean
    print(P, Q)