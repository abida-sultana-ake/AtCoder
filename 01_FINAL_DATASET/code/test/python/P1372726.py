n = int(input())
ans = 101

for i in range(n):
    ans = min(ans, int(input()))

print(ans)
