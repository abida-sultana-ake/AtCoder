n = int(input())
k = int(input())

x = list(map(int, input().split(" ")))

ans = 0
for i in range(n):
    if(x[i] > abs(k - x[i])):
        ans += abs(k - x[i]) * 2
    else:
        ans += x[i] * 2

print(ans)