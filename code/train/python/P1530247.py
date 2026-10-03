n = int(input())
src = map(int, input().split())
ans = 0
for a in src:
    if a%6 in (2,4):
        ans += 1
    elif a%6 == 5:
        ans += 2
    elif a%6 == 0:
        ans += 3
print(ans)
