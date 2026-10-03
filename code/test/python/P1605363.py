N = int(input())
T = [int(i) for i in input().split()]
M = int(input())
for i in range(M):
    P, X = map(int, input().split())
    U = T[P-1]
    T[P-1] = X
    print(sum(T))
    T[P-1] = U
    