import sys

N, M = map(int, input().split())
a = []
b = []

for i in range(M):
    c, d = map(int, input().split())
    a.append(c)
    b.append(d)

s = set()

for i in range(M):
    if b[i] == N:
        s.add(a[i])

for i in range(M):
    if a[i] == 1 and b[i] in s:
        print('POSSIBLE')
        sys.exit()

print('IMPOSSIBLE')
