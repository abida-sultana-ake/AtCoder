# -*- coding:utf-8 -*-

# input N
n = int(input())
a = [0] * (n+1)

s = 1
for i in range(2, n+1):
    for j in range(2, i):
        if i % j == 0:
            break
    else:
        for k in range(2, n+1):
            while k >= i:
                if k % i == 0:
                    a[i] += 1
                    k /= i
                else:
                    break

for i in range(2, n+1):
    if a[i] != 0:
        a[i] += 1
        s *= a[i]

print(s % (pow(10, 9) + 7))
