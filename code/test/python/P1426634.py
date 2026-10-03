def calc(x,y):
    z = x+y
    b.append(z)
    return z
from functools import reduce
import numpy as np
N = int(input())
a = list(map(int, input().split()))
s = sum(a)
b = [a[0]]
reduce(calc ,a)
print(min(abs(2 * np.array(b[0:N-1]) -s )))