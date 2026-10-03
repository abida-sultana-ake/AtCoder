import sys

# sys.stdin = open('b1.in')


def read_int_list():
    return list(map(int, input().split()))


def read_str_list():
    return input().split()


def read_int():
    return int(input())


def read_str():
    return input()


def main():
    a, b, c, d = read_int_list()
    res = abs(max(a, c) - min(b, d))
    if c >= b or a >= d:
        res = 0
    print(res)


main()
