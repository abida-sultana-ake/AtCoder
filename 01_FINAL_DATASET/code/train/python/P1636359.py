import math

n = int(input())
ans = len(str(n))

for i in range(1, int(math.sqrt(n))+1):
    if n % i == 0:
        ans = min(ans, max(len(str(i)), len(str(n // i))))
print(ans)
