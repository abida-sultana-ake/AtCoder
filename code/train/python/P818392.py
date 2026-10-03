H, W, A, B = map(int, input().split())

class Combin(object):
    def __init__(self, max_n, mod = 10**9 + 7):
        self.max_n = max_n
        self.mod = mod
        self.fac = self._init_factorials()
        self.inv = self._init_inv()
        
    def _init_factorials(self):
        N = self.max_n
        mod = self.mod
        f = 1
        fac = [1] * (N + 1)
        for i in range(1, N + 1):
            f *= i
            f %= mod
            fac[i] = f
        return fac

    def _init_inv(self):
        N = self.max_n
        mod = self.mod
        ret = pow(self.fac[N], mod - 2, mod)
        inv = [1] * (N + 1)
        inv[N] = ret
        for i in range(N-1, 0, -1):
            ret *= i + 1
            ret %= mod
            inv[i] = ret
        return inv

    def nCb(self, n, b):
        return (self.fac[n] * self.inv[b] * self.inv[n-b]) % self.mod


def solve(H, W, A, B):
    mod = 10 ** 9 + 7
    cb = Combin(H + W)
    ans = cb.nCb(H + W - 2, H - 1)
    t1 = B + H - 1
    t2 = B - 1
    t3 = W - B - 2
    t4 = W - B - 1
    for a in range(1, A + 1):
        d = cb.nCb(t1 - a, t2) * cb.nCb(t3 + a, t4)
        ans -= d
        ans %= mod
    return ans

print(solve(H, W, A, B))