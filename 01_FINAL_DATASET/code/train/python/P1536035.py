from collections import defaultdict
from itertools import product
from math import pi


def main():
    N, S, T = map(int, input().split())
    W = int(input())
    ans = S <= W <= T
    for _ in range(N - 1):
        A = int(input())
        W += A
        ans += S <= W <= T
    print(ans)

if __name__ == '__main__':
    main()
