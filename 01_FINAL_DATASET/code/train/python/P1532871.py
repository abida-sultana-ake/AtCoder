import numpy as np


def getInput():
    separator = ' '
    ret_array = []
    while True:
        try:
            row = input().split(sep=separator)
            ret_array.append(row)
        except EOFError:
            break
    return ret_array


g = getInput()

N = np.int32(g[0][0])

# ls:0 initial 1 horz 2 vert
ls = 0
cs = None
l = []
i = 0
hoge=[]
try:
    while True:
        # cc = currently checking u = upper l = lower
        hoge.append(g[2][0][i])
        if g[1][0][i] == g[2][0][i]:
            cs = 2
            i += 1
        else:
            cs = 1
            i += 2

        if ls == 0:
            if cs == 1:
                l.append(6)
            else:
                l.append(3)
        elif ls == 1:
            if cs == 1:
                l.append(3)
            else:
                l.append(1)
        else:
            l.append(2)

        ls = cs

except IndexError:
    print(np.mod(np.prod(np.array(l, dtype=np.int32)),1000000007))
