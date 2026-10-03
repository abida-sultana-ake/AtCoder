from collections import Counter


def check(n, a):
    aa = Counter(a)
    if n & 1 and (0 not in aa or aa[0] != 1):
        return False
    for i in range(1 + (n & 1), n + 1, 2):
        if i not in aa or aa[i] != 2:
            return False
    return True


def solve():
    n = int(input())
    a = list(map(int, input().split()))

    if not check(n, a):
        return 0

    exp = n // 2
    if exp < 30:
        return 2 ** exp
    c = 2 ** 29
    d = int(1e9) + 7
    exp -= 29
    for _ in range(exp):
        c = c * 2 % d
    return c


print(solve())
