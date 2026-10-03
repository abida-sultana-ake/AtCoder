x1, y1, r = tuple(map(int, input().split(' ')))
x2, y2, x3, y3 = tuple(map(int, input().split(' ')))

def exist_red():
    if set((x1 - r, x1 + r)) <= set(range(x2, x3 + 1)) and set((y1 - r, y1 + r)) <= set(range(y2, y3 + 1)):
        return False
    else:
        return True

def exist_blue():
    tmp = [(x2, y2), (x2, y3), (x3, y2), (x3, y3)]
    tmp = map(lambda xy: (xy[0] - x1) ** 2 + (xy[1] - y1) ** 2, tmp)
    for t in tmp:
        if t >= r ** 2:
            break
    else:
        return False
    return True

if exist_red():
    print('YES')
else:
    print('NO')

if exist_blue():
    print('YES')
else:
    print('NO')