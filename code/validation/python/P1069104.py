n = input()
s = input()
ans = 0
x = 0
for c in s:
    if c == "I":
        x += 1
        ans = max(ans, x)
    else:
        x -= 1
print(ans)
