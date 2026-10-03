n, m = map(int, input().split())
one = [0 for i in range(n + 1)]
edges = []
for i in range(m):
    a, b = map(int, input().split())
    if a == 1:
        one[b] = 1
    if b == 1:
        one[a] = 1
    else:
        edges.append((a, b))
for a, b in edges:
    if one[a] and b == n or one[b] and a == n:
        print('POSSIBLE')
        exit(0)
print('IMPOSSIBLE')
