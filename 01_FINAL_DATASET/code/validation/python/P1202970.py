
def solve():
    mod = 10**9 + 7
    W, H = map(int, input().split())
    N = W - 1 + H - 1

    fact = [1] * (N + 1)

    for i in range(2, N + 1):
        fact[i] = (i * fact[i - 1]) % mod

    ans = (fact[N] * powmod(fact[W - 1], mod - 2, mod)) % mod
    ans = (ans * powmod(fact[H - 1], mod - 2, mod)) % mod

    print(ans)

def powmod(x, y, mod):
    if y == 0:
        return 1

    return (((powmod(x, y >> 1, mod) ** 2) % mod) * x**(y & 1)) % mod

if __name__ == '__main__':
    solve()