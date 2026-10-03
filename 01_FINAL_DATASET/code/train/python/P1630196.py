s = input()
i = 0
while i < len(s):
    if s[i]=='o' or s[i]=='k' or s[i]=='u':
        i += 1
    elif s[i]=='c'and s[i+1]=='h':
        i += 2
    else:
        print('NO')
        break
else:
    print('YES')