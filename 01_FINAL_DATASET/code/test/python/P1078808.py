N = int(input())
T = list(map(int,input().split()))
M = int(input())
P = []
X = []
for i in range(M):
    a, b =map(int,input().split())
    P.append(a)
    X.append(b)
for i in range(M):
    print(sum(T) - T[P[i]-1] + X[i])