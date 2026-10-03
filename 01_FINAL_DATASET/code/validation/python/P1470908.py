n = input()
a = map(int, input().split())

res = set()
for e in a:
    while e % 2 == 0:
        e /= 2
    res.add(e)
print(len(res))
