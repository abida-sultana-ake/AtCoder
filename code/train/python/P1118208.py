def SW_next(i, s, t):
    if t[i - 1] == 'S':
        if s[i - 1] == 'o':
            if t[i - 2] == 'S':
                return('S')
            else:
                return('W')
        else:
            if t[i - 2] == 'S':
                return('W')
            else:
                return('S')
    else:
        if s[i - 1] == 'o':
            if t[i - 2] == 'S':
                return('W')
            else:
                return('S')
        else:
            if t[i - 2] == 'S':
                return('S')
            else:
                return('W')

def SW_check(n, s, t):
    i = 2
    while i < n:
        t = t + SW_next(i, s, t)
        i += 1
    if t[0] == SW_next(n, s, t):
        tmp_s = [s[n - 1]]
        tmp_s.append(s[0])
        tmp_t = [t[n - 1]]
        tmp_t.append(t[0])
        if t[1] == SW_next(2, tmp_s, tmp_t):
            print(t)
            return(True)
    return(False)

n = int(input())
s = input()

if not SW_check(n, s, 'SS'):
    if not SW_check(n, s, 'SW'):
        if not SW_check(n, s, 'WS'):
            if not SW_check(n, s, 'WW'):
                print(-1)
