s = input()
t = input()
ans = "You can win"

for x, y in zip(s, t):
    if x == y:
        continue
    elif x == '@' and y in "atcoder":
        continue
    elif y == '@' and x in "atcoder":
        continue
    else:
        ans = "You will lose"
        break

print(ans)