#!/usr/bin/env python3

import math


DEFAULT_NUM_ITER = 200
INV_GR = (math.sqrt(5) - 1) / 2  # 黄金比の逆数
MAX_X = 1e3  # 数式処理システムによる
MIN_X = 0.0


# 黄金分割探索により、f(x)の[a, b]における最小値を与えるxを求める
# Based on https://en.wikipedia.org/wiki/Golden_section_search
def calc_min_gss(f, a, b, num_iter=DEFAULT_NUM_ITER):
    def compute_cd(a0, b0):
        return (b0 - INV_GR * (b0 - a0), a0 + INV_GR * (b0 - a0))
    c, d = compute_cd(a, b)
    for _ in range(num_iter):
        if f(c) < f(d):
            b = d
        else:
            a = c
        c, d = compute_cd(a, b)
    else:
        return (b + a) / 2


def compute_min_time(p):
    def f(x): return x + p * 2 ** (-x / 1.5)
    x0 = calc_min_gss(f, MIN_X, MAX_X)
    return f(x0)


def main():
    print("{:.12f}".format(compute_min_time(float(input()))))


if __name__ == '__main__':
    main()
