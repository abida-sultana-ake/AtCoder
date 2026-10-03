n = int(input())
ox = str(input())
ans = -1
ss = [1, 1]
sw = [1, -1]
ws = [-1, 1]
ww = [-1, -1]
line = [ss, sw, ws, ww]

for c in ox[1:]:
    for s in line:
        if c == "o":
            if s[-1] == 1:
                s.append(s[-2])
            else:
                s.append(s[-2] * -1)
        else:
            if s[-1] == -1:
                s.append(s[-2])
            else:
                s.append(s[-2] * -1)

for s in line:
    if s[0] == s[-1]:
        if ox[0] == "o":
            if (s[0] == 1 and s[1] == s[-2]) or (s[0] == -1 and s[1] != s[-2]):
                ans = ""
                for i in s[:-1]:
                    if i == 1:
                        ans += "S"
                    else:
                        ans += "W"
        else:
            if (s[0] == -1 and s[1] == s[-2]) or (s[0] == 1 and s[1] != s[-2]):
                ans = ""
                for i in s[:-1]:
                    if i == 1:
                        ans += "S"
                    else:
                        ans += "W"
print(ans)
