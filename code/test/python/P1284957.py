L = list(map(int, input().split(' ')))

import numpy as np
maxi = np.argmax(L)
maxv = L.pop(maxi)

if maxv == sum(L):
    print('Yes')
else:
    print('No')