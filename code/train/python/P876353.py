def calc(s, f):
    n = len(s)
    li = []
    t = ""
    for i in range(n):
        t += s[i]
        if f & 1:
            li.append(t)
            t = ""
        f >>= 1
    if t:
        li.append(t)
    return sum(map(int, li))


s = input()
ans = 0
for i in range(1 << (len(s) - 1)):
    ans += calc(s, i)
print(ans)
