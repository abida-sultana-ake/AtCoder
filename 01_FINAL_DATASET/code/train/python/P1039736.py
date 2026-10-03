from collections import defaultdict
from itertools import combinations


def func(i, d, now, use, st):
    if i >= d:
        st.append(now)
        return

    for x in use:
        func(i + 1, d, now + str(x), use, st)


def solve():
    n, k = map(int, input().split())
    d = list(map(int, input().split()))

    use = []
    for i in range(10):
        if i not in d:
            use.append(i)

    for i in range(len(str(n)), len(str(n)) + 2):
        st = []
        func(0, i, "", use, st)
        for x in sorted(st):
            if int(x) >= n:
                return x


def main():
    print(solve())


if __name__ == '__main__':
    main()
