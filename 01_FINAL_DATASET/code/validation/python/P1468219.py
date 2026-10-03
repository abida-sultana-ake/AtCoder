# -*- coding: utf-8 -*-
import sys

N, = list(map(int, sys.stdin.readline().rstrip().split()))
As = list(map(int, sys.stdin.readline().rstrip().split()))


def solve_mini():
    def argmax():
        Amax = max(As)
        for j, value in enumerate(As):
            if Amax == value:
                return j

    for i in range(10 ** 20):
        if max(As) < N:
            break
        arg = argmax()
        for j in range(N):
            if j == arg:
                As[j] -= N
            else:
                As[j] += 1
    return i


i = 0
if sum(As) > N * N:
    over = sum(As) - N * N
    # print(over)
    for j in range(N):
        As[j] += over
    # print(As)
    real_i = 0
    for j in range(N):
        diff = (As[j] // (N+1) - 1)
        As[j] -= diff * (N+1)
        real_i += diff
    # print(real_i, over)
    # print(As)
    for j in range(N):
        As[j] += (real_i - over)
    # print(As)
    i += real_i

i += solve_mini()

print(i)
