import sys

# sys.stdin = open('d1.in')


def read_int_list():
    return list(map(int, input().split()))


def read_str_list():
    return input().split()


def read_int():
    return int(input())


def read_str():
    return input()


def main():
    k = read_int()
    n = 50
    q, r = divmod(k, n)
    a = [q + (n - 1)] * n
    for i in range(r):
        a[i] += n - r + 1
    for i in range(r, n):
        a[i] -= r
    print(n)
    print(*a)


main()
