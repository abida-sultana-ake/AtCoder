
res = 0


for _ in range(3):
    s, e = map(int, input().split())
    res += s * e // 10

print(res)