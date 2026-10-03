import sys
from collections import defaultdict
from itertools import product
from math import pi
from collections import deque
INF = 10 ** 10


def main():
    N = int(input())

    node1, max_dist = 0, 0
    for node in range(2, N + 1):
        print("? {0} {1}".format(1, node))
        sys.stdout.flush()
        dist = int(input())
        if dist > max_dist:
            node1, max_dist = node, dist
    ans = 0
    for node2 in range(1, N + 1):
        if node2 == node1:
            continue
        print("? {0} {1}".format(node1, node2))
        sys.stdout.flush()
        dist = int(input())
        ans = max(ans, dist)
    print("! {0}".format(ans))


if __name__ == '__main__':
    main()
