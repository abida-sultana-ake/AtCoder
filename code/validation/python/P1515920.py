s = input()
r = s[::-1]

num = []

ans = s.replace("*", "0")
ans = list(ans)

for i in range(len(s)):
    if r[i] == "*":
        ans[i] = 0

ans = "".join(map(str, ans))
reverse = ans[::-1]

if ans == reverse:
    print("YES")
else:
    print("NO")
