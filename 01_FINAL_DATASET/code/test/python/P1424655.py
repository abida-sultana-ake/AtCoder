n = int(input())
a = list(map(int,input().split()))

sum1 = [0] * n
sum2 = [0] * n
sum1[0] = a[0]
sum2[-1] = a[n - 1]

for i in range(1, n):
    sum1[i] = sum1[i - 1] + a[i]
    sum2[-i - 1] = sum2[-i] + a[-i - 1]

d = 10 ** 10
index = 0

for i in range(n - 1):
    if abs(sum1[i] - sum2[i + 1]) < d:
        d = abs(sum1[i] - sum2[i + 1])

print(d)