N, K = map(int, input().split())

d = []
for _ in range(N):
    a, b = map(int, input().split())
    d.append((a, b))

d.sort(key=lambda x: x[0])

c = 0
for p in d:
    c += p[1]
    if c >= K:
        print(p[0])
        break
