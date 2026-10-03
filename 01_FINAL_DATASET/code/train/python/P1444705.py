def solve_slow(X):
    for n in range(1000000):
        # print((n * (n - 1) // 2))
        if (n * (n - 1) // 2) >= X:
            break
    return n - 1


def solve_fast(X):
    # n^2 - n - 2X <= 0
    # n = (1 + sqrt(1 + 8X)) // 2
    n = max(int((1 + (1 + 8 * X) ** 0.5) / 2) - 1, 0)
    while True:
        if (n * (n - 1) // 2) >= X:
            break
        n += 1
    return n - 1


X = int(input())
print(solve_fast(X))