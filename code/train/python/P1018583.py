S=str(input())
S=S[::-1]
while True:
    if S[:5]=='maerd':
        S=S[5:]

    elif S[:7]=='remaerd':
        S=S[7:]
    elif S[:5]=='esare':
        S=S[5:]
    elif S[:6]=='resare':
        S=S[6:]
    elif len(S)==0:
        print('YES')
        exit()
    else:
        print('NO')
        exit()
