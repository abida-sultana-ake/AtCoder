x = input()
li = list(map(str, input()))
ans = []

for i in range(len(li)):
    a = li[i]
    if x != a:
        ans.append(a)
ans = "".join(map(str, ans))
print(ans)
