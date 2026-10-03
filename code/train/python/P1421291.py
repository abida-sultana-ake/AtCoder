import math
N = int(input())
n = N % 2
num = N / 2
if n == 0:
    ans = num ** 2
    print(math.floor(ans))
else:
    ans = math.ceil(num) * math.floor(num)
    print(ans)
