
def read():
    return map(int, input().split())


def toString(arr):
    return '\n'.join(map(''.join, arr))

h, w = read()
s = []
for _ in range(h):
    s.append(list(input()))

origin = [['#' for x in range(w)] for y in range(h)]

for i in range(h):
    for j in range(w):
        if s[i][j] == '.':
            origin[i][j] = '.'
            if j > 0:
                origin[i][j - 1] = '.'
            if j < w - 1:
                origin[i][j + 1] = '.'
            if i > 0:
                origin[i - 1][j] = '.'
                if j > 0:
                    origin[i - 1][j - 1] = '.'
                if j < w - 1:
                    origin[i - 1][j + 1] = '.'
            if i < h - 1:
                origin[i + 1][j] = '.'
                if j > 0:
                    origin[i + 1][j - 1] = '.'
                if j < w - 1:
                    origin[i + 1][j + 1] = '.'

check = [['.' for x in range(w)] for y in range(h)]

for i in range(h):
    for j in range(w):
        if origin[i][j] == '#':
            check[i][j] = '#'
            if j > 0:
                check[i][j - 1] = '#'
            if j < w - 1:
                check[i][j + 1] = '#'
            if i > 0:
                check[i - 1][j] = '#'
                if j > 0:
                    check[i - 1][j - 1] = '#'
                if j < w - 1:
                    check[i - 1][j + 1] = '#'
            if i < h - 1:
                check[i + 1][j] = '#'
                if j > 0:
                    check[i + 1][j - 1] = '#'
                if j < w - 1:
                    check[i + 1][j + 1] = '#'

if toString(check) == toString(s):
    print('possible')
    print(toString(origin))
else:
    print('impossible')
