n = int(input())

ans = 0
a = n % 10
if a < 7:
    ans += a * 15
else:
    ans += 100

ans += (n-a) * 10

print(ans)
