n = int(input())
s1 = input()
s2 = input()
mod = 10 ** 9 + 7
table = []
y = 0
for i in range(len(s1)):
    if s1[i] == s2[i]:
        table.append("x")
    else:
        if y == 0:
            table.append("y")
            y += 1
        else:
            y -= 1
if table[0] == "x":
    ans = 3
else:
    ans = 6

for i in range(len(table))[1:]:
    if table[i] == "x":
        if table[i - 1] == "x":
            ans *= 2 % mod
        else:
            pass
    else:
        if table[i - 1] == "x":
            ans *= 2 % mod
        else:
            ans *= 3 % mod
print(ans % mod)
