N, K = [int(i) for i in input().split()]

ans = K

for i in range(N-1):
    ans *= K - 1

print(ans)
