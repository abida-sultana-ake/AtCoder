def a(n, memo={}):
    if n <= 0:
        return 0
    if n not in memo:
        memo[n] = 2 * 10**(n - 1) + a(n - 1) * 8
    return memo[n]

def count(number):
    c = 0
    digits = list(map(int, str(number)))
    for n, d in zip(range(len(digits) - 1, 0, -1), digits[:-1]):
        c += d * a(n) + (d > 4 and 10**n - a(n))
        if d in (4, 9):
            c += number % 10**n + 1
            break
    else:
        c += (0, 0, 0, 0, 1, 1, 1, 1, 1, 2)[digits[-1]]
    return c

def solve(a, b):
    return count(b) - count(a - 1)

A, B = map(int, input().split())
print(solve(A, B))
