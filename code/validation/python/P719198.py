a, b = map(int, input().split())
N = [0] * a
for i in range(b):
    l, r, t = map(int, input().split())
    for j in range(l-1, r):
        N[j] = t
for i in N:
    print(i)