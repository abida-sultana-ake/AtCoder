import sys
from collections import Counter
from functools import reduce

# sys.stdin = open('c1.in')


def read_int_list():
    return list(map(int, input().split()))


def read_str_list():
    return input().split()


def read_int():
    return int(input())


def read_str():
    return input()


n = read_int()
c = []
for i in range(n):
    s = read_str()
    c.append(Counter(s))

r = reduce(lambda x, y: x & y, c)
l = sorted(r.elements())
res = ''.join(l)
print(res)
