import numpy as np
n, m = map(int, input().split())
x = np.array(list(map(int, input().split())), dtype='int64')
y = np.array(list(map(int, input().split())), dtype='int64')

xsum = np.sum(x[:0:-1].cumsum() - x[n-2::-1] * np.arange(1,n))
ysum = np.sum(y[:0:-1].cumsum() - y[m-2::-1] * np.arange(1,m))

print((xsum % 1000000007) * (ysum % 1000000007) % 1000000007)