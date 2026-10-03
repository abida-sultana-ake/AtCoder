import numpy as np

N = int(input())
a = list(map(int, input().split()))

e = len(a) - len(np.unique(a))
if e % 2 == 0:
    print(len(np.unique(a)))
else:
    print(len(np.unique(a)) - 1)