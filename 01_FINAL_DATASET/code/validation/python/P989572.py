from collections import Counter, defaultdict

h, w, n = map(int, input().split())
blacks = defaultdict(int)

for a, b in (map(int, input().split()) for _ in range(n)):
    for y in range(max(0, a - 3), min(a, (h - 2))):
        for x in range(max(0, b - 3), min(b, (w - 2))):
            blacks[(y, x)] += 1

print((h - 2) * (w - 2) - len(blacks))

c = Counter(blacks.values())
for i in range(1, 10):
    print(c[i] if i in c else 0)
