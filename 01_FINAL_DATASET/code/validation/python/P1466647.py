# coding: utf-8

def main():
    N = int(input())
    a = sorted(map(int, input().split()))

    # a[i] >= N な項は少なくともa[i]//N 回選ばれる
    tK = 0
    while max(a) >= N:
        K = 0
        for i in range(N):
            if a[i] >= N:
                k = a[i] // N
                a[i] -= (N + 1) * k
                K += k
        for i in range(N):
            a[i] += K
        tK += K
    return tK


print(main())
