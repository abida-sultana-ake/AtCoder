#!/usr/bin/python
# -*- coding: utf-8 -*-
import sys
import math

K, = list(map(int, sys.stdin.readline().rstrip().split()))

N = 50

As = [0 for _ in range(50)]
if K > 50:
    bias = K // 50
    K = K - bias * 50


    # for i in range(50):
    #     if i < K:
    #         As[i] += (50 + 1 - i + bias * 50)
    #
    if bias > 0:
        for i in range(50):
            As[i] += (50 - i + bias -1 )

    # for i in range(50):
    #     if i < K:
    #         As[N - 1 - i] += (50 - i + bias)
    for i in range(50):
        if i < K:
            As[i] += 1
            # As[i] += (50 - i + bias)
else:
    for i in range(50):
        if i < K:
            As[i] += (50 - i)
print(50)
print(" ".join(map(str, As)))

exit(0)
