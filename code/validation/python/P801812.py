n, m = map(int, input().split())
p = [0] * n
for _ in range(m):
    x, y = map(int, input().split())
    p[y-1] |= 1 << (x-1)
c = [0] * 2**n
c[0] = 1
for i in range(2**n):
    for j in range(n):
        if not ((i>>j)&1 or i&p[j]):
            c[i|(1<<j)] += c[i]
print(c[-1])