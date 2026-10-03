N, M = map(int, input().split())
city = [0] * N
for i in range(0, M):
    a, b = map(int, input().split())
    for j in range(1, N+1):
        if a == j or b == j:
            city[j-1] += 1
for n in range(0, N):
    print(city[n])