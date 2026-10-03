#coding: utf-8
import math

N, A, B = map(int, input().split())
monster = [int(input()) for i in range(N)]


def enough(T):
    attack = B * T
    diff = A-B
    count = 0
    for i in monster:
        tmp = math.ceil((i - attack)/diff)
        if tmp > 0:
            count += tmp

    if count <= T:
        return True
    else:
        return False

def bs():
    left = 0
    right = 1000000000

    while left < right:
        mid = (left + right) // 2
        if enough(mid):
            right = mid
        else:
            left = mid + 1
    return left

print(bs())
