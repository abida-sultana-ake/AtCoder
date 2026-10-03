# coding: utf-8


if __name__ == '__main__':

    n, q = [int(i) for i in input().split(' ')]
    arr = [0] * n

    for _ in range(q):
        l, r, t = [int(i) for i in input().split(' ')]
        arr[l - 1:r] = [t] * (r - l + 1)

    print('\n'.join(str(a) for a in arr))