N, A = map(int, input().split())
xs = map(lambda x: int(x) - A, input().split())

d = dict()
d[0] = 1
for x in xs:
    for s, v in list(d.items()):
        d[s + x] = d.get(s + x, 0) + v

print(d[0]-1)
