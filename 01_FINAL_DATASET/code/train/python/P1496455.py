def read(): return list(map(int, input().split()))


n = input()
a = read()

odd, four, not4 = 0, 0, 0
for i in a:
    if i % 4 == 0:
        four += 1
        continue

    if i & 1:
        odd += 1
    else:
        not4 += 1

odd += (not4 & 1)

print("Yes" if odd <= four + 1 else "No")