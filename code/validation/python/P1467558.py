N, M = map(int, input().split(' '))

one_to_routes = set()
other_routes_contains_N = set()

for _ in range(M):
    a, b = map(int, input().split(' '))

    if a == 1:
        one_to_routes.add(b)
    elif b == N:
        other_routes_contains_N.add(a)

if one_to_routes.isdisjoint(other_routes_contains_N):
    print("IMPOSSIBLE")
else:
    print("POSSIBLE")
