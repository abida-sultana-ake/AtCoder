from fractions import gcd as gcd
a,b,n = [int(input()) for _ in range(3)]
lc = a * b / gcd(a,b)
for i in range(200000):
    if lc * i >= n:
        print(int(lc*i))
        break
