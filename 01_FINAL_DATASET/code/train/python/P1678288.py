N = int(input())
K = int(input())

X = list(map(int, input().split()))

HalfK = K/2.0

Ans = 0

for i in range(N):
    if X[i] > HalfK:
        Ans += 2*(K-X[i])
    else:
        Ans += 2*X[i]
        
print(str(Ans))