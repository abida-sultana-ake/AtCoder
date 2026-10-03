import numpy as np

N, T = map(int, input().split())

t_ary = input().split()
t_ary = np.array([int(e) for e in t_ary])

diff_ary = t_ary[1:] - t_ary[:-1]

#print(diff_ary < T)
#print(diff_ary)

tf_ary = diff_ary < T

total = 0
for i, flag in enumerate(tf_ary):
    if flag:
        total += diff_ary[i]
    else:
        total += T

total += T

print(total)