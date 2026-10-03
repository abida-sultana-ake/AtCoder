N, M = map(int,input().split())
route_1 = set()
route_N = set()

for _ in range(M):
    a, b = map(int,input().split())
    if a == 1:
        route_1.add(b)
    elif b == N:
        route_N.add(a)

if route_1&route_N:
    print("POSSIBLE")
else:
    print("IMPOSSIBLE")