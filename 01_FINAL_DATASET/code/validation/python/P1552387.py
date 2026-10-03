from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10


def is_intersected(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2):
    ta = (bx1 - bx2) * (ay1 - by1) + (by1 - by2) * (bx1 - ax1)
    tb = (bx1 - bx2) * (ay2 - by1) + (by1 - by2) * (bx1 - ax2)
    tc = (ax1 - ax2) * (by1 - ay1) + (ay1 - ay2) * (ax1 - bx1)
    td = (ax1 - ax2) * (by2 - ay1) + (ay1 - ay2) * (ax1 - bx2)

    return tc * td < 0 and ta * tb < 0
    # return tc * td <= 0 && ta * tb <= 0; // 端点を含む場合


def main():
    Ax, Ay, Bx, By = map(int, input().split())
    N = int(input())

    l = []
    for _ in range(N):
        X, Y = map(int, input().split())
        l.append((X, Y))

    num = 0
    for (bx1, by1), (bx2, by2) in zip(l, l[1:] + [l[0]]):
        num += is_intersected(Ax, Ay, Bx, By, bx1, by1, bx2, by2)
    print(num // 2 + 1)

if __name__ == '__main__':
    main()
