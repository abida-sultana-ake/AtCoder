import sys

# sys.stdin = open('a1.in')


def read_int_list():
    return list(map(int, input().split()))


def read_str_list():
    return input().split()


def read_int():
    return int(input())


def read_str():
    return input()


a, b = read_int_list()
if (a + b) % 3 == 0 or a % 3 == 0 or b % 3 == 0:
    print('Possible')
else:
    print('Impossible')
