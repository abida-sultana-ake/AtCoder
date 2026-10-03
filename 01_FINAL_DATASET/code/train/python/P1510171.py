def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a


def lcm(a, b):
    return a*b//gcd(a, b)


N = int(input())
T = [int(input()) for i in range(N)]

T.sort(reverse=True)
ans = 1
for i in T:
    ans = lcm(ans, i)
print(ans)
