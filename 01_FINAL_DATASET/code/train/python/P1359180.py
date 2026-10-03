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


n, m = read_int_list()
x = read_int_list()
y = read_int_list()


def compute_sum(q, a):
    return sum([(2 * p - q - 1) * a[p - 1] for p in range(1, q + 1)])


M = 10 ** 9 + 7
s = compute_sum(n, x)
t = compute_sum(m, y)
res = s * t % M
print(res)
