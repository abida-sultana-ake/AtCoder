import numpy as np

input()
a = np.array(input().split(), dtype=np.int)

diff = a - np.minimum.accumulate(a)
print((diff == diff.max()).sum())

