N, M, D = [int(_) for _ in input().split()]
A = [int(_) for _ in input().split()]

map = list(range(N))
for a in A:
    map[a-1:a+1] = [map[a], map[a-1]]

res = list(range(N))

i = 0
prev = map
while True:
    if 2 ** i > D:
        break

    if (D >> i) & 1 == 1:
        res = [prev[x] for x in res]

    i += 1
    prev = [prev[x] for x in prev]

for index, _ in sorted(enumerate(res), key=lambda x: x[1]):
    print(index + 1)
