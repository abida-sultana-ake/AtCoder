N, K = map(int, input().split())
i = 2
t = [int(input()) for i in range(N)]

while i < N:
    if i == N - 1:
        print(-1)
        break
    tsum = t[i] + t[i-1] + t[i-2]
    if tsum < K:
        print(i+1)
        break
    i += 1
