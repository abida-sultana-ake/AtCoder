import math

N = int(input())
a = []
for i in range(N):
    a.append(int(input()))

a.sort(reverse=True)

result = 0
for i, r in enumerate(a):
    if i % 2:
        result -= r ** 2
    else:
        result += r ** 2

result *= math.pi

print(result)
