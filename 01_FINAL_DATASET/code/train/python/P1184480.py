import math

def f(a,b):
    return max(len(str(a)), len(str(b)))

n = int(input())
v = -1
for i in range(1, math.ceil(math.sqrt(n)) + 1):
    if n % i == 0:
        t = f(int(i), int(n/i))
        if v == -1 or v > t:
            v = t
print(v)