n, q = map(int, input().split())
b = [0] * (n + 1)

for _ in range(q):
    l, r = map(int, input().split())
    b[l - 1] += 1
    b[r] -= 1

mos = [0] * n
mos[0] = b[0]
print(1 if mos[0] % 2 else 0, end = "")
for i in range(1, n):
    mos[i] = b[i] + mos[i - 1]
    print(1 if mos[i] % 2 else 0, end = "")
print()