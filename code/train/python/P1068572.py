N, A, B = list(map(int, input().split()))
X = list(map(int, input().split()))
m = 0

for i in range(N-1):
    m += min(A*(X[i+1]-X[i]),B)

print(m)
