# B
N, L = [int(i) for i in input().split()]
D = sorted([i for i in input().split()])

for i in range(N, 100000):
    if all([s not in D for s in list(str(i))]):
        print(i)
        break