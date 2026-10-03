s = input()
ans = ''
for char in s:
    if char == ',':
        ans += ' '
    else:
        ans += char
print(ans)