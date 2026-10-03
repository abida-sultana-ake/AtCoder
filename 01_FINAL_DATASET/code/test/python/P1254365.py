from collections import Counter

N = int(raw_input())
S = [raw_input() for i in range(0, N)]

c = Counter(S)
print(reduce(lambda x, y: x if c[x] >= c[y] else y, c))
