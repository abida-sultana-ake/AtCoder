s = str(input())
a = [s[0]]
b = [0]
ans = ""

for i in s:
    if i == a[-1]:
        b[-1] += 1
    else:
        a.append(i)
        b.append(1)

for i in range(len(a)):
    ans += a[i] + str(b[i])

print(ans)