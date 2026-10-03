from collections import Counter
import math
S = input()
cnt = Counter()
for word in S:
    cnt[word] += 1
odd = 0
for i in "abcdefghijklmnopqrstuvwxyz":
    odd += cnt[i] % 2
cube = (len(S) - odd) / 2
if odd == 0:
    print(len(S))
else:
    print((int(cube / odd))*2+1)