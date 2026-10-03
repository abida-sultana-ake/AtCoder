s = input().split()
ans = "YES"
a = s[0][-1]
for i in s[1:]:
    if i[0] != a:
        ans = "NO"
    else:
        a = i[-1]
print(ans)
