time = int(input())
ans = 0
for i in range(time):
    now = input().split()
    ans += int(now[1]) + 1 - int(now[0])
print(ans)
