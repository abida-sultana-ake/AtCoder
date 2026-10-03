import math
a = int(input())
b = int(input())
n = int(input())
'''
koubiasu = math.gcd(a, b)
ans = a * b / koubiasu
if ans >= n:
    print(math.ceil(ans))
else:
    c = math.ceil(n / ans)
    ans *= c
    print(math.ceil(ans))
'''
while True:
    if n % a == 0 and n % b == 0:
        print(n)
        break
    n += 1
