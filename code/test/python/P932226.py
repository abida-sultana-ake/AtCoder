def judge(my, another):
    if my == another:
        return 0
    elif my == 'g':
        return -1
    else:
        return 1

s = input()

g, p = 0, 0
point = 0
for c in s:
    if p >= g:
        #print("自分の手はグー")
        point += judge('g', c)
        g += 1
    else:
        #print("自由に選べる")
        if c == 'g':
            point += 1
            p += 1
        else:
            p += 1

        
print(point)