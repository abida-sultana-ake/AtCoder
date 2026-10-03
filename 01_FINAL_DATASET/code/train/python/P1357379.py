N, X = tuple(map(int, input().split()))
a = list(map(int, input().split()))

X = list(bin(X))
X.reverse()
del X[-2:]

while len(X) < N:
    X.append('0')

S = 0
for i in range(N):
    if X[i] == '1':
        S += a[i]

print(S)