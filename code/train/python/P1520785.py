from collections import defaultdict
from itertools import product, combinations
import bisect


def main():
    l1, l2, l3 = list(map(int, input().split()))
    if l1 == l2:
        print(l3)
    elif l1 == l3:
        print(l2)
    elif l2 == l3:
        print(l1)

if __name__ == '__main__':
    main()
