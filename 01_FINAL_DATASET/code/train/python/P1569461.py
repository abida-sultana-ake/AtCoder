from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10


# 90度右に回転
def rotate(field):
    ans = []
    for x in range(len(field[0])):
        ans.append([field[-y-1][x] for y in range(len(field))])

    return ans


def main():
    field = []
    for _ in range(4):
        field.append(input().split())
    ans = rotate(rotate(field))
    for line in ans:
        print(*line)



if __name__ == '__main__':
    main()
