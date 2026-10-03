from collections import Counter

def primeDecomposition(n):
    d = {}
    i = 2
    while i * i <= n and n > 1:
        while n % i == 0:
            n = int(n / i)
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
        i += 1
    
    if n > 1:
        d[n] = 1
    
    return d

N = int(input())
primesCounter = Counter()
for i in range(2, N + 1):
    p = primeDecomposition(i)
    primesCounter += Counter(p)

Nprimes = 1
for i, p in primesCounter.items():
    Nprimes *= p + 1

print(Nprimes % int(1e9 + 7))