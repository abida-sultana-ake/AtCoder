import math

N = int(input())

power = math.factorial(N)
ans = power % (10**9 + 7)

print(ans)
