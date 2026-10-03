buy = [0 for i in range(1000002)]
n = int(input())
for j in range(n):
    a, b = list(map(int, input().split()))
    buy[a] += 1
    buy[b+1] -= 1
for i in range(1, 1000001):
    buy[i] += buy[i-1]
print(max(buy))
