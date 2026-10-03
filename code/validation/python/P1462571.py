N, M = map(int, input().split())
E1 = set()
EN = set()
for n in range(M):
    a, b = map(int, input().split())
    if a == 1:
        E1.add(b)
    if b == 1:
        E1.add(a)
    if a == N:
        EN.add(b)
    if b == N:
        EN.add(a)
for a in E1:
    if a in EN:
        print("POSSIBLE")
        break
else:
    print("IMPOSSIBLE")


