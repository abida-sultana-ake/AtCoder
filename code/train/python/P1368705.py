import sys

# sys.stdin = open('d1.in')


def read_int_list():
    return list(map(int, input().split()))


def read_int():
    return int(input())


def read_str_list():
    return input().split()


def read_str():
    return input()


def solve(n, k, a):
    filter(lambda x: x < k, a)
    n = len(a)
    a.sort()
    s = 0
    lowest = None
    for i in range(n - 1, -1, -1):
        if k - a[i] <= s:
            # a[i] is not unnecessary
            lowest = i
        else:
            # maybe a[i] is unnecessary
            s += a[i]
    if lowest is None:
        return n
    return lowest

n, k = read_int_list()
a = read_int_list()
res = solve(n, k, a)
print(res)
