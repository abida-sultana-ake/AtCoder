k, s = [int(i) for i in input().split()]
ans = 0
for x in range(k, -1, -1):
    for y in range(k, -1, -1):
        if 0 <= s - x - y <= k:
            ans += 1
print(ans)
