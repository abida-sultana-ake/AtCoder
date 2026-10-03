input()
s = input()
pair = ["SS", "SW", "WS", "WW"]
replace = {"S": "W", "W": "S"}
hasFound = False
for i in pair:
    for j in s[1:]:
        if j is 'o':
            if i[-1] is 'S':
                i += i[-2]
            else:
                i += replace[i[-2]]
        else:
            if i[-1] is 'S':
                i += replace[i[-2]]
            else:
                i += i[-2]
    if i[0] is i[-1]:
        if s[0] == 'o':
            hasFound = i[0] is 'S' and i[-2] is i[1] or i[0] is 'W' and i[-2] is not i[1]
        else:
            hasFound = i[0] is 'S' and i[-2] is not i[1] or i[0] is 'W' and i[-2] is i[1]
    if hasFound:
        print(i[:-1])
        break
if not hasFound:
    print(-1)