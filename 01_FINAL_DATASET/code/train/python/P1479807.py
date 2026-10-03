


class Combination:
    def __init__(self, mod):
        self.mod = mod
        self.fact = [1] * (2 * 10 ** 5 + 1)
        for i in range(1, 2 * 10 ** 5 + 1):
            self.fact[i] = i * self.fact[i - 1] % self.mod

    def nCr(self, n, k):
        a = self.fact[n] % self.mod
        b = (self.fact[k] * self.fact[n - k]) % self.mod
        c = pow(b, self.mod - 2, self.mod)
        return a * c % self.mod


def main():
    H, W, A, B = map(int, input().split())
    MOD = 10 ** 9 + 7
    c = Combination(mod=MOD)

    ans = 0
    for i in range(W - B):
        h, w = H - A - 1, B + i
        a = c.nCr(h + w, h) % MOD

        h, w = A - 1, W - B - i - 1
        b = c.nCr(h + w, h) % MOD

        ans = (ans + a * b) % MOD

    print(ans % MOD)


if __name__ == '__main__':
    main()

