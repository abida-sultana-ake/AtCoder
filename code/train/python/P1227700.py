s=str(input())
u=''
for i in range(0,len(s)):
    if s[i]=='0':
        u=u+'0'
    elif s[i]=='1':
        u=u+'1'
    else:
        u=u[:-1]
print(u)