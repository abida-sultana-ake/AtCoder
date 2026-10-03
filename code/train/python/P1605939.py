
n = int(input())
xs = map(int, input().split())

res = 0
for a in xs:
    while (a % 3 != 0 and a % 3 != 1) or a % 2 != 1:
        res += 1
        a -= 1
print(res)