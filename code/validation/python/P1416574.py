N = int(input())
K = int(input())
X = int(input())
Y = int(input())

if N > K:
    print(X * K + Y * (N - K))
else:
    print(X * N)