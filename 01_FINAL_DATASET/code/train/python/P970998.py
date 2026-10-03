
s = input()
prev = 'N'
ans = -1


for s_i in s:
    if prev != s_i:
        prev = s_i
        ans += 1

print(ans)
