from collections import Counter, defaultdict
h, w, n = map(int, input().split())
ab = [[int(i)-1 for i in input().split()] for j in range(n)]

d = defaultdict(int)

for i in range(n):
    for j in range(3):
        for k in range(3):
            if ab[i][0] - j >= 0 and ab[i][1] - k >= 0 and ab[i][0] - j < (h - 2) and ab[i][1] - k < (w - 2):
                d[(ab[i][0]-j, ab[i][1]-k)] += 1

print((h-2)*(w-2)-len(d))

c = Counter(d.values())
for i in range(1, 10):
    print(c[i] if i in c else 0)