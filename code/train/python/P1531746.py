from collections import defaultdict
from itertools import product
from math import pi
import copy

b, c = None, None


def calc_score(field):
    score = 0
    for y in range(3):
        for x in range(3):
            if y + 1 < 3 and field[y][x] == field[y + 1][x]:
                score += b[y][x]
            if x + 1 < 3 and field[y][x] == field[y][x + 1]:
                score += c[y][x]
    return score

memo = {}


def lt(l):
    return tuple(l[0]), tuple(l[1]), tuple(l[2])


def dfs(i, field):
    if i >= 9:
        return calc_score(field)

    if lt(field) in memo:
        return memo[lt(field)]

    mark = i % 2
    best_score = 0 if mark == 0 else 10 ** 10
    for y in range(3):
        for x in range(3):
            if field[y][x] is None:
                field[y][x] = mark
                score = dfs(i + 1, field)
                field[y][x] = None

                if mark == 0 and score > best_score:
                    best_score = score
                if mark == 1 and score < best_score:
                    best_score = score

    memo[lt(field)] = best_score
    return best_score


def main():
    global b, c
    b1 = list(map(int, input().split()))
    b2 = list(map(int, input().split()))
    b = [b1, b2]
    c1 = list(map(int, input().split()))
    c2 = list(map(int, input().split()))
    c3 = list(map(int, input().split()))
    c = [c1 + [0], c2 + [0], c3 + [0]]

    field = [[None] * 3 for _ in range(3)]
    score = dfs(0, field)
    total = sum([sum(x) for x in b + c])
    print(*[score, total - score], sep="\n")


if __name__ == '__main__':
    main()
