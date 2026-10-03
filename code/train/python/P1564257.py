N = int(input())
p = map(int, input().split())

a = [0] * (10 ** 5 + 1)
for i, p_i in enumerate(p, 1):
    if i == p_i:
        a[i - 1] = 1

count = 0
for i in range(10 ** 5):
    if a[i] == 1:
        a[i] = 0
        a[i + 1] = 0
        count += 1

print(count)