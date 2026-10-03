k = int(input())
n = 50
d = k // n
a = [d + i for i in range(n)]  # d*n operations
k = k % n
for i in range(k):
    a[i] += n
    for j in range(n):
        if j != i:
            a[j] -= 1
print(n)
print(' '.join(map(str, a)))
