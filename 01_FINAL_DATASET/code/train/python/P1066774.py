def main():
    N = int(input())

    primes = sieve(N+1)
    res = 1
    for p in primes:
        f = 0
        i = 1
        while p ** i <= N:
            f += (N//(p**i))
            i += 1
        res *= f + 1
        res = res % (10**9 + 7)

    print(res)

def sieve(n):
    s = [True] * n
    for x in range(2, int(n**0.5) + 1):
        if s[x]: mark(s, x)
    return [i for i in range(0,n) if s[i] and i > 1]

def mark(s, x):
    for i in range(x + x, len(s), x):
        s[i] = False

if __name__ == "__main__":
    main()
