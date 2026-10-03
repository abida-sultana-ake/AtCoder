from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10


def func1(d):
    l = ["NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"]
    for i, x in enumerate(range(1125, 34875, 2250)):
        if x <= d * 10 < x + 2250:
            return l[i]
    return "N"


def func2(d):
    m = dict()
    m[0] = (0.0, 0.2)
    m[1] = (0.3, 1.5)
    m[2] = (1.6, 3.3)
    m[3] = (3.4, 5.4)
    m[4] = (5.5, 7.9)
    m[5] = (8.0, 10.7)
    m[6] = (10.8, 13.8)
    m[7] = (13.9, 17.1)
    m[8] = (17.2, 20.7)
    m[9] = (20.8, 24.4)
    m[10] = (24.5, 28.4)
    m[11] = (28.5, 32.6)
    m[12] = (32.7, 12000)

    for a, b in m.items():
        if b[0] <= round(d / 60 + 0.001, 1) <= b[1]:
            return a
    return 0


def main():
    Deg, Dis = map(int, input().split())

    a = func1(Deg)
    b = func2(Dis)
    print("C" if b == 0 else a, b)


if __name__ == '__main__':
    main()
