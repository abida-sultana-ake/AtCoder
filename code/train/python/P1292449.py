c = []
init = [[True for i in range(8)] for j in range(8)]

def func(q, b):
    if len(q) == 5:
        for p in q:
            c[p[0]][p[1]] = "Q"
        return True
    for i in range(8):
        for j in range(8):
            if b[i][j]:
                new_b = [[y for y in x] for x in b]
                for x in range(8):
                    new_b[i][x] = False
                    new_b[x][j] = False
                    if i-x >= 0:
                        if j-x >= 0:
                            new_b[i-x][j-x] = False
                        if j+x < 8:
                            new_b[i-x][j+x] = False
                    if i+x < 8:
                        if j-x >= 0:
                            new_b[i+x][j-x] = False
                        if j+x < 8:
                            new_b[i+x][j+x] = False
                if func(q + [(i,j)],new_b) == True:
                    return True
    return False

initflag = True
for i in range(8):
    l = list(input())
    for j in range(8):
        if l[j] == "Q":
            if init[i][j] == False:
                initFlag = False
                print("No Answer")
                exit()
            for x in range(8):
                init[i][x] = False
                init[x][j] = False
                if i-x >= 0:
                    if j-x >= 0:
                        init[i-x][j-x] = False
                    if j+x < 8:
                        init[i-x][j+x] = False
                if i+x < 8:
                    if j-x >= 0:
                        init[i+x][j-x] = False
                    if j+x < 8:
                        init[i+x][j+x] = False
    c.append(l)

if func([], init):
    for t in c:
        print("".join(t))
else:
    print("No Answer")