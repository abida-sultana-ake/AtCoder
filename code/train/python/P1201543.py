#!/usr/bin/env python3
# -*- coding: utf-8 -*-


def deg2dir(deg):
    DIRS = (
        "N", "NNE", "NE", "ENE",
        "E", "ESE", "SE", "SSE",
        "S", "SSW", "SW", "WSW",
        "W", "WNW", "NW", "NNW"
    )

    STEP = 36000 / 16

    for i in range(1, 16):
        lower = STEP*i - STEP//2
        upper = STEP*i + STEP//2
        if lower <= 10*deg < upper:
            return DIRS[i]

    return DIRS[0]


def dis2w(dis):
    THRESHOLDS = tuple(60 * x for x in (
         0,
         0.25,
         1.55,
         3.35,
         5.45,
         7.95,
        10.75,
        13.85,
        17.15,
        20.75,
        24.45,
        28.45,
        32.65
    ))

    for i in range(len(THRESHOLDS) - 1):
        lower = THRESHOLDS[i]
        upper = THRESHOLDS[i+1]
        if lower <= dis < upper:
            return i

    return len(THRESHOLDS) - 1


def main():
    deg, dis = map(int, input().split())

    dir_ = deg2dir(deg)
    w    = dis2w(dis)

    if w == 0: dir_ = "C"

    print("{} {}".format(dir_, w))

if __name__ == "__main__": main()
