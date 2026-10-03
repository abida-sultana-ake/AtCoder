from collections import defaultdict
from itertools import product
from math import pi


class Combination:
    def __init__(self, n, mod):
        assert 0 < n
        self.mod = mod
        self.fact = [1] * (n + 1)
        self.inv = [1] * (n + 1)
        for i in range(1, len(self.fact)):
            self.fact[i] = (i * self.fact[i - 1]) % self.mod
            self.inv[i] = pow(self.fact[i], self.mod - 2, self.mod)

    def nCr(self, n, k):
        assert 0 < n < len(self.fact) and 0 < k
        a = self.fact[n]
        b = (self.inv[k] * self.inv[n - k]) % self.mod
        return a * b % self.mod


def main():
    mod = 10 ** 9 + 7

    n = int(input())
    k = int(input())
    if n == 1:
        print(1)
        return

    c = Combination(n + k, mod)
    print(c.nCr(n + k - 1, n - 1))


if __name__ == '__main__':
    main()
