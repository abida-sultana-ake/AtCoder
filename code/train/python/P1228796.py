N, K = list(map(int, input().split()))
R = list(map(int, input().split()))

R.sort()
Rate = 0
for i in range(N-K, N):
    Rate = (Rate + R[i])/2

print(Rate)
