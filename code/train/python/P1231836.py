a, b, c, d = map(int, input().split())

taka = b/a
aoki = d/c

ans = str()
if taka > aoki:
    ans = "TAKAHASHI"
elif taka < aoki:
    ans = "AOKI"
else:
    ans = "DRAW"

print(ans)
