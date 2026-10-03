N, M = map(int, input().split())

f = set()
t = set()

for i in range(M):
    a, b = map(int, input().split())
    if a == 1:
        f.add(b)
    elif a == N:
        t.add(b)
    if b == 1:
        f.add(a)
    elif b == N:
        t.add(a)

pos = "IMPOSSIBLE"

if f&t:
    pos = "POSSIBLE"

print(pos)