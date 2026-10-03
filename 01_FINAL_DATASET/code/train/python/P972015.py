s = input()

count = 0
now = s[0]
for i, c in enumerate(s[1:]):
    if now != c:
        now = c
        count += 1
print(count)

