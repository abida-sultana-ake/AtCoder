# coding: utf-8

import math
from functools import reduce


def solve(A):
    return math.ceil((lambda l:sum(l)/len(l))(list(filter(lambda a:a > 0, A))))


n = int(input())
A = map(int, input().split())
print(solve(A))
