# coding: utf-8
import array, bisect, collections, copy, heapq, itertools, math, random, re, string, sys, time

sys.setrecursionlimit(10 ** 7)
INF = 10 ** 20
MOD = 10 ** 9 + 7


def II(): return int(input())
def ILI(): return list(map(int, input().split()))
def IAI(LINE): return [ILI() for __ in range(LINE)]
def IDI(): return {key: value for key, value in ILI()}


def read():
    N = II()
    C = [II() for __ in range(N)]
    return N, C


def solve(N, C):
    # 最初に色が変わるindexを探す
    fir_ind = 0
    for ind, ele in enumerate(C):
        if ele != C[0]:
            fir_ind = ind
            break
    else:
        return -1

    C_2 = C * 2
    max_len = 0
    now_len = 1
    now_color = C[fir_ind]

    for i in range(fir_ind, fir_ind + N):
        if C_2[i] != now_color:
            max_len = max(max_len, now_len)
            now_len = 1
            now_color = C_2[i]
        else:
            now_len += 1
    else:
        max_len = max(max_len, now_len)

    return (max_len - 1) // 2 + 1


def main():
    params = read()
    print(solve(*params))


if __name__ == "__main__":
    main()
