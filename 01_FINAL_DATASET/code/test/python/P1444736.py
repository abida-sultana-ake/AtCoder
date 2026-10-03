from collections import defaultdict


def eratos(n):
    if n <= 1:
        return []
    used = [False] * n
    used[0] = used[1] = True
    primes = []
    for i in range(n):
        if used[i] is False:
            primes.append(i)
            for j in range(i * 2, n, i):
                used[j] = True
    return primes


n = int(input())
primes = eratos(n + 1)
primes_dict = defaultdict(lambda: zip(primes, [1] * len(primes)))
X = n
d = 2
defactors = defaultdict(int)

for i in range(2, n + 1):
    if primes_dict[i] == 1:
        defactors[i] += 1
        continue

    for prime in primes:
        if i == 1:
            continue
        while i % prime == 0:
            defactors[prime] += 1
            i //= prime

ans = 1
mod = 10 ** 9 + 7
for key, value in defactors.items():
    ans = (ans * (value + 1)) % mod 
print(ans)

