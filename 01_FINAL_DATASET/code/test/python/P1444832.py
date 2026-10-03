N = int(input())
a = list(map(int, input().split()))

total_cost = float('inf')
for n in range(-100, 101):
    cost = 0
    for i in range(N):
        cost += (a[i] - n) ** 2
    total_cost = min(total_cost, cost)
print(total_cost)
