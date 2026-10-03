def check(x, y):
    def __check(tx, ty):
        if tx < 0 or tx >= w or ty < 0 or ty >= h:
            return True
        if p[ty][tx] == '#':
            return True
        else:
            return False

    f = True
    for mx, my in ((i, j) for i in range(-1, 2) for j in range(-1, 2)):
        if not __check(x + mx, y + my):
            f = False
            break
    return f

def recheck(x, y):
    def __recheck(tx, ty):
        if tx < 0 or tx >= w or ty < 0 or ty >= h:
            return False
        if rp[ty][tx] == '#':
            return True
        else:
            return False

    f = False
    for mx, my in ((i, j) for i in range(-1, 2) for j in range(-1, 2)):
        if __recheck(x + mx, y + my):
            f = True
            break
    return f

h, w = map(int, input().split(' '))
p = [input() for i in range(h)]
rp = [['.' for i in range(w)] for j in range(h)]
for i in range(h):
    for j in range(w):
        if check(j, i):
            rp[i][j] = '#'

ok = True
for i in range(h):
    for j in range(w):
        if p[i][j] == '#' and not recheck(j, i):
            ok = False

if ok:
    print('possible')
    for tp in rp:
        print(''.join(tp))
else:
    print('impossible')