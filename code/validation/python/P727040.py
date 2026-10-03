import numpy as np

N = int(input())
arr = np.array([list(map(int, input().split())) for i in range(N)])
X = arr[:, 0]
Y = arr[:, 1]
C = arr[:, 2]

MAX_TIME = (10 ** 5) * 2 * 1000
THRESHOLD = 10 ** -4
NUM_ITER = int(np.log2(MAX_TIME / THRESHOLD)) + 2

upper = MAX_TIME
lower = 0
for i in range(NUM_ITER):
    t = (upper + lower) / 2
    if max(X - t / C) <= min(X + t / C):
        upper = t
    else:
        lower = t
t_X = t

upper = MAX_TIME
lower = 0
for i in range(NUM_ITER):
    t = (upper + lower) / 2
    if max(Y - t / C) <= min(Y + t / C):
        upper = t
    else:
        lower = t
t_Y = t

print(max(t_X, t_Y))
