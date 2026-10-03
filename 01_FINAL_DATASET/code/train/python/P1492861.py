N, M = map(int, input().split())
from1 = set()
toN = set()
for _ in range(M):
    a, b = map(int, input().split())
    if a == 1:
        from1.add(b)
    if b == N:
        toN.add(a)
msg = "IMPOSSIBLE" if from1.isdisjoint(toN) else "POSSIBLE"
print(msg)
