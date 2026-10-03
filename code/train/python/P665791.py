s = list(input())
check = list(map(int,input().split()))
check.sort()
count = 0
for c in check:
    s.insert(c + count,'"')
    count += 1

ans = "".join(s)

print(ans)
