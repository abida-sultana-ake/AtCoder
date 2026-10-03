S = input().upper()
i = c = False
for s in S:
    if s == 'I':
        i = True
    elif i and s == 'C':
        c = True
    elif i and c and s == 'T':
        print('YES')
        exit()
print('NO')