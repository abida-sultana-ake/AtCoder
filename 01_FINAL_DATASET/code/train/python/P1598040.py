def read_line(*types): return [f(a) for a, f in zip(input().split(), types)]

n, = read_line(int)
k, = read_line(int)
xs = [int(x) for x in input().split()]

cost = 0
for x in xs:
    cost += min(x, k - x) * 2
print(cost)
