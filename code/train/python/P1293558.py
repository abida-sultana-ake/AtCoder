import itertools
import numpy as np

# get INDATA
INDATA = np.array(list(map(int, input().split())))
CALCDATA = np.empty(10, dtype=int)
COUNT = 0
for (a, b, c) in itertools.combinations(INDATA, 3):
    CALCDATA[COUNT] = a + b + c
    COUNT += 1

S_CALCDATA = np.sort(CALCDATA)

# output
print(S_CALCDATA[7])
