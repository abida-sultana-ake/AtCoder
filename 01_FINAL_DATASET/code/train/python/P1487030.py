from itertools import chain

h, w = map(int, input().split())
n = int(input())
field = chain.from_iterable([i + 1] * a for i, a in enumerate(map(int, input().split())))
for r, row in enumerate(zip(*[field] * w)):
    if r & 1:
        print(*reversed(row))
    else:
        print(*row)
