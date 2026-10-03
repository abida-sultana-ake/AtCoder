from collections import Counter


def mk_table(n):
    res = [1] * (n + 1)
    res[:2] = 0, 0

    for i in range(2, n):
        if i ** 2 > n:
            break

        if res[i] == 1:
            for j in range(i * 2, n + 1, i):
                res[j] = 0

    return [i for i, x in enumerate(res) if x == 1]


def solve():
    N = int(input())
    if N == 1:
        print(1)
        return

    primes = mk_table(N)
    c = Counter()
    for i in range(2, N + 1):
        n = i
        for p in primes:
            if p > n:
                break
            while 0 == (n % p):
                c[p] += 1
                n //= p

    res = 1
    for v in c.values():
        res = (res * (v + 1)) % (1e9 + 7)

    print(int(res))


solve()
