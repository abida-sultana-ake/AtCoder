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


n = read_int()
res = 0
for i in range(100):
    r = 2 ** i
    if r <= n:
        res = r
    else:
        break
print(res)
