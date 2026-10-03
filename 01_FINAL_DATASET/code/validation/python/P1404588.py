n = int(input())
l = list(map(int, input().split()))

total = 0
ans1 = 0
ans2 = 0

for i, j in enumerate(l):
    total += j
    if i % 2 == 1:
        if total <= 0:
            ans1 += 1 + abs(total)
            total = 1
    else:
        if total >= 0:
            ans1 += 1 + abs(total)
            total = -1

total = 0

for i, j in enumerate(l):
    total += j
    if i % 2 == 0:
        if total <= 0:
            ans2 += 1 + abs(total)
            total = 1
    else:
        if total >= 0:
            ans2 += 1 + abs(total)
            total = -1

print(min(ans1, ans2))
