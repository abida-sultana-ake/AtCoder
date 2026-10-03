# -*- coding: utf-8 -*-
import numpy as np

K = int(input())

a = np.ones(50).astype(np.int64)*(49) + (K)//50


if K%50 != 0:
    a[:K%50] += 51 - (K%50)
    a[K%50:] -= (K%50)
else:
    pass
                
result = "50\n{}".format(a[0])
for a_ in a[1:]:
    result += (" {}".format(int(a_)))
print(result)