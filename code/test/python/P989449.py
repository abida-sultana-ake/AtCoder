import itertools
w, h, n = map(int, input().split())

field = [[0 for x in range(w)] for y in range(h)]

a = [list(map(int, input().split())) for x in range(n)]

def a1(line):
    for l in field:
        for x in range(line[0]):
            l[x] = 1

def a2(line):
    for l in field:
        for x in range(line[0], w):
            l[x] = 1

def a3(line):
    for y in range(line[1]):
        field[h - y - 1] = [1 for x in range(w)]

def a4(line):
    for y in range(line[1], h):
        field[h - y - 1] = [1 for x in range(w)]

for line in a:
    globals()["a" + str(line[2])](line[:2])

print(list(itertools.chain(*field)).count(0))
