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
N = g[0][0]
A = np.array(g[1], dtype=np.int32)
A = np.sort(A, kind='mergesort')
A = A[::-1]

idx = 0
ph = np.empty((2,), dtype=np.int32)
try:
    for c in range(0, 2):
        while True:
            if A[idx] == A[idx + 1]:
                ph[c] = A[idx]
                idx += 2
                break
            else:
                idx += 1
except IndexError:
    print(0)
    exit()

print(np.prod(ph))