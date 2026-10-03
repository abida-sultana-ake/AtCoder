s = input()

i = len(s)
p = ''
while i>=5:
    if s[i-5:i] == 'dream':
        i -= 5
    elif s[i-5:i] == 'erase':
        i -= 5
    elif i>= 6 and s[i-6:i] == 'eraser':
        i -= 6
    elif i>= 7 and s[i-7:i] == 'dreamer':
        i -= 7
    else:
        print('NO')
        exit()
if i == 0:
    print('YES')
else:
    print('NO')