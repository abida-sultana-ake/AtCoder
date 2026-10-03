s = input()

length = len(s)

res = -1
for i in range(length - 1):
    subs = s[i:i+2]
    if len(set(subs)) < 2:
        res = i
        break

if res == -1:
    for i in range(length - 2):
        subs = s[i:i+3]
        if len(set(subs)) < 3:
            res = i
            break
    if res == -1:
        print('-1 -1')
    else:
        print('%d %d' % (res + 1, res + 3))
else:
    print('%d %d' % (res + 1, res + 2))
