from collections import Counter

n = input()
ac = Counter(map(int, input().split()))

w, h = 0, 0
for i in sorted(ac.keys(), reverse=True):
    if ac[i] == 1:
        continue
    if w:
        h = i
        break
    if ac[i] >= 4:
        w = h = i
        break
    w = i

print(w * h)
