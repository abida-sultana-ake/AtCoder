N = int(input())
a = list(map(int, input().split()))
ret = N * 200**2
for i in range(-100, 101):
    cost = 0
    for j in range(N):
        cost += (i - a[j])**2
    ret = min(ret, cost)
print(ret)
