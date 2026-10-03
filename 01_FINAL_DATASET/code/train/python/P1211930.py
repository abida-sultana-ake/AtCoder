n = int(input())
s = input()

a = False
b = False

sw = [None] * n

sw[0] = True
sw[1] = True

def next(s,sw,j,i):
    if s[i] == 'o':
        return not (sw[j] ^ sw[i])
    else:
        return sw[j] ^ sw[i]

def printsw(sw,n):
    s = ''
    for i in range(n):
        if sw[i]:
            s += 'S'
        else:
            s += 'W'
    print(s)

flag = True

for j in range(4):
    for i in range(2,n):
        sw[i] = next(s,sw,i-2,i-1)

    zero = next(s,sw,n-2,n-1)
    one = next(s,sw,n-1,0)
    if zero == sw[0]:
        if one == sw[1]:
            printsw(sw,n)
            flag = False
            break

    sw[0] = not sw[0]
    if j == 1:
        sw[1] = False

if flag:
    print(-1)
