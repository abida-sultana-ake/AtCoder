from collections import Counter
c = Counter(list(input()))
f = int(input()) == 1
t = abs(c['U'] - c['D']) + abs(c['L'] - c['R'])
if f or t > c['?']:
    print(t + c['?'] if f else t - c['?'])
else:
    print((c['?'] - t) % 2)
