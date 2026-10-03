from itertools import product
s = input()
ans = 0
op = ["", "+"]
for b in product(range(2), repeat = len(s) - 1):
    v = s[0]
    for j in range(1, len(s)):
        v += op[b[j - 1]] + s[j]
    ans += eval(v)

print(ans)
