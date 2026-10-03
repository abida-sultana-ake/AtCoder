# coding: utf-8

import math
import sys


def split_3(h, w):
    cand = []
    cand.extend([(h // 3 + i, w, h - (h // 3 + i), w) for i in range(3)])
    cand.extend([(h, w // 3 + i, h, w - (w // 3 + i)) for i in range(3)])
    return cand


def split_2(h, w):
    cand = []
    cand.extend([((h // 2 + i) * w, (h - (h // 2 + i)) * w) for i in range(2)])
    cand.extend([(h * (w // 2 + i), h * (w - (w // 2 + i))) for i in range(2)])
    return cand


def main():
    h, w = map(int, input().split())
    if h % 3 == 0 or w % 3 == 0:
        return 0

    cand = split_3(h, w)
    score = float("inf")
    for h1, w1, h2, w2 in cand:
        r1 = h1 * w1
        for r2, r3 in split_2(h2, w2):
            score = min(score, max(r1, r2, r3) - min(r1, r2, r3))
    return score


if __name__ == "__main__":
    print(main())
