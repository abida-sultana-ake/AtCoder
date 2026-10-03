from collections import defaultdict

MOD = 10 ** 9 + 7

# nを素因数分解する(O(n ^ (1 / 2)))
# primeFactorDecomposition(12): {2: 2, 3: 1}
def prime_factor_decomposition(n):
    import math
    m = defaultdict(int)
    while n > 1:
        find_factor = False
        for i in range(2, int(math.sqrt(n)) + 1):

            if n % i == 0:
                m[i] += 1
                n //= i
                find_factor = True
                break

        if not find_factor:
            m[n] += 1
            break

    return m


def main():
    N = int(input())
    m = defaultdict(int)
    for i in range(1, N + 1):
        d = prime_factor_decomposition(i)
        for k, v in d.items():
            m[k] += v
    ans = 1
    for k, v in m.items():
        ans = (ans * (v + 1)) % MOD

    print(ans)

if __name__ == '__main__':
    main()
