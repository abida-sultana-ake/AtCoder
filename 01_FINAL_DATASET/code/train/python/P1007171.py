s = input()

a = 0
for i in range(1, len(s)):
    if s[i - 1] != s[i]:
        a += 1

print(a)
