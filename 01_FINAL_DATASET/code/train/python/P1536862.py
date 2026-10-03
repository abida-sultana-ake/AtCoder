from collections import defaultdict
from itertools import product
from math import pi


def main():
    N = int(input())
    a, b = map(int, input().split())
    K = int(input())
    P = list(map(int, input().split()))
    l = [a, b] + P
    print("YES" if len(l) == len(set(l)) else "NO")


if __name__ == '__main__':
    main()
