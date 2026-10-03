from math import factorial as fact
from itertools import product as prod

r, c = map(int, input().split())
x, y = map(int, input().split())
d, l = map(int, input().split())

pos_pattern = (r - x + 1) * (c - y + 1)

def C(n, k):
    return fact(n) // (fact(k) * fact(n - k))

# x * y 区画におけるデスクとラックの配置パターン
def dl_pattern(x, y):
    xy = x * y
    if xy < d + l:
        return 0
    return C(xy, d) * C(xy - d, l)

n = x * y
m = 10**9 + 7
# x * y == d + l ならば(デスクの置き方) == (ラックの置き方)
if n == d + l:
    desk_pattern = C(n, d) % m

# 上下左右の辺いずれかが空白であるときについて包除原理より考える
# 2行以上または2列以上空白であることは無いため(その場合は x, y の条件に不適当)
# 考えるパターンは上下左右の辺のいずれかが全て空白であるパターンを考えれば十分
else:
    desk_pattern = 0
    # us: 上辺, ds: 下辺, ls: 左辺, rs: 右辺
    for us, ds, ls, rs in prod([0, 1], repeat=4):
        pattern = dl_pattern(x - ls - rs, y - us - ds)
        if (us + ds + ls + rs) % 2 == 0:
            desk_pattern += pattern
        else:
            desk_pattern -= pattern

ans = pos_pattern * desk_pattern
ans = ans % m
print(ans)
