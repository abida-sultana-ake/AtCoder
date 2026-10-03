N = int(input())
a = list(map(int, input().split()))
ap = [e + 1 for e in a]
am = [e - 1 for e in a]

table = [0 for _ in range(10**5 + 2)]
for e in a:
    table[e + 1] += 1
    table[(e+1) + 1] += 1
    table[(e-1) + 1] += 1
print(max(table))

