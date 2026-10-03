two = ["SS", "SW", "WS", "WW"]
n = int(input())
s = input()
flip = {"S":"W", "W":"S"}
flag = False

for i in two:
    for j in s[1:]:
        if j == 'o':
            if i[-1] == 'S':
                i += i[-2]
            else:
                i += flip[i[-2]]
        else:
            if i[-1] == 'S':
                i += flip[i[-2]]
            else:
                i += i[-2]
    if i[0] == i[-1]:
        if s[0] == 'o':
            if i[0] == 'S' and i[-2] == i[1] or i[0] == 'W' and i[-2] != i[1]:
                flag = True
        else:
            if i[0] == 'S' and i[-2] != i[1] or i[0] == 'W' and i[-2] == i[1]:
                flag = True
    if flag:
        print(i[:-1])
        break
if not flag:
    print(-1)
