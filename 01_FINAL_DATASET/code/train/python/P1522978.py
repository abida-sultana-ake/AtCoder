# coding: utf-8
from collections import defaultdict


def II(): return int(input())
def ILI(): return list(map(int, input().split()))


def read():
    N = II()
    A = ILI()
    return N, A


def solve(N, A):
    count = defaultdict(int)
    for a in A:
        count[a] += 1
    l_len = [(key, value) for key, value in count.items() if value >= 2]
    l_len.sort(key= lambda x: -x[0])
    if len(l_len) <= 1:
        ans = 0
    else:
        if l_len[0][1] >= 4:
            ans = l_len[0][0] ** 2
        else:
            ans = l_len[0][0] * l_len[1][0]
    return ans


def main():
    params = read()
    print(solve(*params))


if __name__ == "__main__":
    main()
