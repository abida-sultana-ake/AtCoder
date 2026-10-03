s = input()

base = ord('a')
backet = [0 for i in range(ord('z') - base + 1)]
for c in s:
    backet[ord(c) - base] += 1

n = 0
r = 0
for cnt in backet:
    if cnt % 2 == 1:
        n += 1
        r += cnt - 1
    else:
        r += cnt
if n == 0:
    print(len(s))
else:
    p = ((r//2) // n)
    print(2 * p + 1)