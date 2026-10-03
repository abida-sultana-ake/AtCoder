S=input()[::-1]

preS=''
while len(S)!=0 and S!=preS:
    preS = S;
    pre = S[:7]
    if pre[:7][::-1] == 'dreamer':
        S=S[7:]
    elif pre[:6][::-1] == 'eraser':
        S=S[6:]
    elif pre[:5][::-1] == 'dream':
        S=S[5:]
    elif pre[:5][::-1] == 'erase':
        S=S[5:]

if len(S)==0:
    print('YES')
else:
    print('NO')
