n, q = map(int, input().split())
b = [0] * (n + 1)
c = [0] * n
sum = 0
for i in range(q):
    l, r = map(int, input().split())
    b[l - 1] += 1
    b[r] -= 1
for i in range(n):
    sum += b[i]
    c[i] = sum % 2
print(''.join(map(str, c)))
