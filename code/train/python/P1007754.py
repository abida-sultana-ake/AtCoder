n = int(input())
a = [int(i) for i in input().split()]

mincost = 10000000
for i in range(-100, 101):
    cost = 0
    for j in range(n):
        cost += (a[j]-i) ** 2
    mincost = min(cost, mincost)

print(mincost)