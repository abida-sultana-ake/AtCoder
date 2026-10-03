#!/usr/bin/env python3

# AtCoder Regular Contest 054 B. ムーアの法則
# 三分探索による解答例

import math


DEFAULT_NUM_ITER = 200
INV_GR = (math.sqrt(5) - 1) / 2  # 黄金比の逆数
MAX_X = 1e3  # 数式処理システムによる
MIN_X = 0.0


# 三分探索により、f(x)の[a, b]における最小値を与えるxを求める
# Based on https://en.wikipedia.org/wiki/Ternary_search
def calc_min_ternary(f, a, b, num_iter=DEFAULT_NUM_ITER):
    for _ in range(num_iter):
        left_third = (2 * a + b) / 3
        right_third = (a + 2 * b) / 3
        if f(left_third) > f(right_third):
            a = left_third
        else:
            b = right_third
    return (a + b) / 2


def compute_min_time(p):
    def f(x): return x + p * 2 ** (-x / 1.5)
    x0 = calc_min_ternary(f, MIN_X, MAX_X)
    return f(x0)


def main():
    print("{:.12f}".format(compute_min_time(float(input()))))


if __name__ == '__main__':
    main()
