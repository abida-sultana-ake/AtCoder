import sys
from collections import Counter

# sys.stdin = open('c1.in')


def read_int_list():
    return list(map(int, input().split()))


def read_int():
    return int(input())


def read_str_list():
    return input().split()


def read_str():
    return input()


def solve():
    n = read_int()
    a = read_int_list()
    res = 0
    c = Counter(a)
    for i in range(10 ** 5 + 1):
        r = c[i-1] + c[i] + c[i+1]
        if r> res:
            res = r
    return res


def main():
    res = solve()
    print(res)


if __name__ == '__main__':
    main()
