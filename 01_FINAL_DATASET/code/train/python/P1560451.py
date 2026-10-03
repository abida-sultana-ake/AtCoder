n = int(input())
flag = False
ans = 0
for i, a in enumerate(map(int, input().split())):
    if not flag and i + 1 == a:
        ans += 1
        flag = True
    else:
        flag = False
print(ans)
