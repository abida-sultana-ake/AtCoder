s = input()
e = len(s)

while e > 0:
    if e >= 5 and (s[e-5:e] == 'dream' or s[e-5:e] == 'erase'):
        e -= 5
    elif e >= 6 and s[e-6:e] == 'eraser':
        e -= 6
    elif  e >= 7 and s[e-7:e] == 'dreamer':
        e -= 7
    else:
        break

if e == 0:
    print("YES")
else:
    print("NO")

