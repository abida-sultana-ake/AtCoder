n = int(input())

c = {}
r = 0
for i in range(n):
    a = int(input())
    if c.get(a) is None:
        c[a] = 0
    else:
        r+=1

print(r)
