
N = int(input())
ans = 0

for i in range(N):
    a, b = map(int, input().split())
    ans += a * b

ans = (ans * 105) // 100

print(ans)