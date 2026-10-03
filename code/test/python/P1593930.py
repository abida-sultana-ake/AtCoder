N = int(input())
T = list(map(int, input().split()))
M = int(input())
sm = sum(T)
for i in range(M):
    P, X = list(map(int, input().split()))
    print(sm + X-T[P-1])