n, m = map(int, input().split())
counts = [0] * (n + 1)
for _ in range(m):
    a, b = map(int, input().split())
    counts[a] += 1
    counts[b] += 1
print('\n'.join(map(str, counts[1:])))
