from collections import Counter, defaultdict

h, w, n = map(int, input().split())
hs, ws = h - 2, w - 2
dd = defaultdict(int)

for a, b in (map(int, input().split()) for _ in range(n)):
    for y in range(max(0, a - 3), min(a, hs)):
        for x in range(max(0, b - 3), min(b, ws)):
            dd[(y, x)] += 1

print(hs * ws - len(dd))

c = Counter(dd.values())
for i in range(1, 10):
    print(c[i] if i in c else 0)
