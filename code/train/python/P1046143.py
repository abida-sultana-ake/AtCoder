# -*- coding:utf-8 -*-
from collections import Counter

def check(n, a):
    count = Counter(a)
    if n % 2 == 1 and (0 not in count or count[0] != 1):
        return False
    for i in range(1 + (n % 2), n+1, 2):
        if i not in count or count[i] !=2:
            return False
    return True

if __name__ == "__main__":
    N = int(input())
    A = list(map(int, input().split()))

    if not check(N,A):
        print(0)
    else:
        if N > 1:
            c = 2
            for _ in range((N // 2) - 1):
                c = c * 2 % (int(1e9) + 7)
            print(c)
        else:
            print(1)
