import sys


# sys.stdin = open('c1.in')


def read_int_list():
    return list(map(int, input().split()))


def read_int():
    return int(input())


def read_str_list():
    return input().split()


def read_str():
    return input()


def solve():
    n = read_int()
    a = read_int_list()
    b = [0] * n
    p = 0
    q = n - 1
    for i in range(n-1, -1, -1):
        if i % 2 == (n-1) % 2:
            b[p] = a[i]
            p += 1
        else:
            b[q] = a[i]
            q += -1
    return ' '.join(map(str, b))


def main():
    res = solve()
    print(res)


if __name__ == '__main__':
    main()
