#!/usr/bin/env python3
#
# まず1次元で考える
#   |  |   |  |
#   a  b   c  d
# とあるとき、長さの合計は
#  (b-a) + (c-a) + (d-a) + (c-b) + (d-b) + (d-c)
# = 3d + c - b - 3a
# これは、各点の座標を、<自分より左にある点の数> - <自分より右にある点の数> でかけたものの和である
#
# もとめる面積は X座標、Y座標それぞれについて蒸気を計算した積

MOD = 1000000007

def len_sum(Xs):
    size = len(Xs)
    ret = 0
    n = len(Xs) - 1
    # 負の値にMODをとることを防ぐため、座標の大きい点から計算する
    for x in reversed(Xs):
        ret += n * x
        ret %= MOD
        n -= 2
    return ret

def solve(Xs, Ys):
    x_len_sum = len_sum(Xs)
    y_len_sum = len_sum(Ys)
    return (x_len_sum * y_len_sum) % MOD

N, M = map(int, input().split())
Xs = list(map(int, input().split()))
Ys = list(map(int, input().split()))
print(solve(Xs, Ys))
