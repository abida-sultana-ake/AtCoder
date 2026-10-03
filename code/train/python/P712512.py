s = list(input())
l = len(s)
numstr = "0123456789"
num = list(numstr)
ans = ""
for i in range(l):
    if s[i] in num:
        ans += s[i]
        if i+1 < l and s[i+1] in num:
            ans += s[i+1]

        break

print(ans)
