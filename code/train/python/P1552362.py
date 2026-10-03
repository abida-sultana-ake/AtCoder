from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
from copy import copy
INF = 10 ** 10


def main():
    N, M = map(int, input().split())
    friends = defaultdict(set)
    for _ in range(M):
        A, B = map(int, input().split())
        friends[A].add(B)
        friends[B].add(A)

    friends_friends = defaultdict(set)
    for i in range(1, N + 1):
        for friend1 in friends[i]:
            for friend2 in friends[friend1]:
                friends_friends[i].add(friend2)

    for i in range(1, N + 1):
        fre = copy(friends[i])
        fre.add(i)
        fre2 = friends_friends[i]
        print(len(fre2.difference(fre)))


if __name__ == '__main__':
    main()
