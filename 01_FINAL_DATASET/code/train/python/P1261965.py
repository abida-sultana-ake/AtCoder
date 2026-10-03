N, K = map(int, input().split())
R = list(map(int, input().split()))
C = 0
R.sort()

for i in range(N-K, N):
    C = (C+R[i])/2

print(C)



