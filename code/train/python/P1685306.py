import numpy as np


N, H = map(int, input().split(' '))
A, B, C, D, E = map(int, input().split(' '))

y_max = (E * N - H) / (D + E)
if y_max <= 0:
    print(0)
else:
    cand = []
    for i in range(N + 1):
        y = (-(B + E) * i + E * N - H) / (D + E)
        if y > 0:
            cand.append([i, int(y + 1.0)])
        else:
            cand.append([i, 0])
    cand = np.array(cand) * np.array([A, C])
    print(np.min(np.sum(cand, axis=1)))
