s = input()
count = 0
prev, s = s[0], s[1:]
for c in s:
    if prev != c:
        count += 1
    prev = c
print(count)
