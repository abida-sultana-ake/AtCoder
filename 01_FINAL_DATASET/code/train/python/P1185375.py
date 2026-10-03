n = int(input())

a = []
b = []

import math

for i in range(1, math.floor(n**0.5) + 1):
    if n%i == 0:
        a.append(i)
        b.append(int(n/i))

a = list(map(str, a))
b = list(map(str, b))


result = []
for i in range(len(a)):
    result.append(max(len(a[i]), len(b[i])))

print(min(result))
