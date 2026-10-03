from copy import deepcopy

def show(src):
    for row in src:
        for pixel in row:
            print(pixel, end='')
        print()

h, w = map(int, input().split())

src = []
for i in range(h):
    src.append(list(input()))

dst = deepcopy(src)

for i in range(h):
    for j in range(w):
        if src[i][j] == '.':
            if i - 1 >= 0 and j - 1 >= 0:
                dst[i - 1][j - 1] = '.'
            if i - 1 >= 0:
                dst[i - 1][j    ] = '.'
            if i - 1 >= 0 and j + 1 < w:
                dst[i - 1][j + 1] = '.'
            if j - 1 >= 0:
                dst[i    ][j - 1] = '.'
            if j + 1 < w:
                dst[i    ][j + 1] = '.'
            if i + 1 < h and j - 1 >= 0:
                dst[i + 1][j - 1] = '.'
            if i + 1 < h:
                dst[i + 1][j    ] = '.'
            if i + 1 < h and j + 1 < w:
                dst[i + 1][j + 1] = '.'

reverse = deepcopy(dst)

for i in range(h):
    for j in range(w):
        if dst[i][j] == '#':
            if i - 1 >= 0 and j - 1 >= 0:
                reverse[i - 1][j - 1] = '#'
            if i - 1 >= 0:
                reverse[i - 1][j    ] = '#'
            if i - 1 >= 0 and j + 1 < w:
                reverse[i - 1][j + 1] = '#'
            if j - 1 >= 0:
                reverse[i    ][j - 1] = '#'
            if j + 1 < w:
                reverse[i    ][j + 1] = '#'
            if i + 1 < h and j - 1 >= 0:
                reverse[i + 1][j - 1] = '#'
            if i + 1 < h:
                reverse[i + 1][j    ] = '#'
            if i + 1 < h and j + 1 < w:
                reverse[i + 1][j + 1] = '#'

if reverse == src:
    print('possible')
    show(dst)
else:
    print('impossible')