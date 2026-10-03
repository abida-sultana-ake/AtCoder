ans = 0
for i in range(3):
    s, e = list(map(int, input().split()))
    ans += s * e * 0.1
print(int(ans))
