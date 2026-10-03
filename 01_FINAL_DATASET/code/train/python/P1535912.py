from collections import defaultdict
from itertools import product
from math import pi


def ok(score, balloon_list):
    upper_time_list = [None] * len(balloon_list)
    for i, (h, s) in enumerate(balloon_list):
        if h > score:
            return False
        t = (score - h) // s
        upper_time_list[i] = t

    upper_time_list.sort()
    for i in range(len(upper_time_list)):
        if upper_time_list[i] < i:
            return False

    return True


def main():
    N = int(input())
    balloon_list = []
    for _ in range(N):
        H, S = map(int, input().split())
        balloon_list.append((H, S))

    # [low, high)
    low, high, ans = -1, int(1e14) - 1, -1
    while high - low > 1:
        middle = (low + high) // 2
        if ok(middle, balloon_list):
            ans = middle
            high = middle
        else:
            low = middle

    print(ans)



if __name__ == '__main__':
    main()
