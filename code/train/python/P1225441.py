import numpy as np

N = int(input())
x = np.arange(N)
x = x + 1
ave = np.mean(x)
print (int(ave*10000))