from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10


def main():
    K = int(input())
    a = [i + (K // 50) for i in range(50)]
    for i in range(K % 50):
        for j in range(50):
            a[j] += 50 if i == j else -1
    print(50)
    print(*a)


if __name__ == '__main__':
    main()
