# -*- coding: utf-8 -*-

# 入力の数値6つ
x, y, a, b, c, d = map(int, input().split())
# (0,0), (a,b), (c,d) を作る
# x - x = 0
a -= x
c -= x
# y - y = 0
b -= y
d -= y
# |ad−bc|⁄2に当てはめる
num1 = a * d - b * c
# 絶対値
num1 = abs(num1)
num1 = num1 / 2
# 出力
print(num1)
