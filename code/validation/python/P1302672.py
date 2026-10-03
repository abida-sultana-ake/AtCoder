w, h = map(int, input().split())
w -= 1
h -= 1
n = w + h
m = 1000000007

# fact ができない


def fact(x):
    result = x
    for i in range(1, x):
        result *= i
        if result >= m:
            result %= m
    return  result


def powmod(a, b, m):
    if b == 0:
        return 1
    if b % 2:
        return a * powmod(a, b - 1, m) % m
    else:
        return powmod(a, b // 2, m) ** 2 % m


result = (fact(n) % m) * powmod((fact(w) * fact(h) % m), (m - 2), m) % m

print(result)
