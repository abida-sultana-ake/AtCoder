data = list(map(int, input().split()))
N, A, B = data
dist = list(map(int, input().split()))
cost = 0
for i in range(N-1):
    cost += min((dist[i+1] - dist[i])*A, B)
print(cost)