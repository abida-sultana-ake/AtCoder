import sys
from collections import Counter

M = 10 ** 9 + 7

# sys.stdin = open('c1.in')


def read_int_list():
    return list(map(int, input().split()))


def read_str_list():
    return input().split()


def read_int():
    return int(input())


def read_str():
    return input()


def solve():
    n = read_int()
    a = read_int_list()

    c = Counter(a)
    expected = Counter()
    if n % 2 == 0:
        for i in range(1, n, 2):
            expected[i] = 2
    else:
        expected[0] = 1
        for i in range(2, n, 2):
            expected[i] = 2

    if c == expected:
        return pow(2, n // 2, M)
    return 0


def main():
    res = solve()
    print(res)


main()
