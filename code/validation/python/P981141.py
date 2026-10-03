def solve(a):
    m, diff, ans = 10 ** 10, 0, 0
    for i in range(len(a)):
        if a[i] < m:
            m = a[i]
        elif a[i] - m > diff:
            diff = a[i] - m
            ans = 1
        elif a[i] - m == diff:
            ans += 1

    return ans


def solve2(a):
    if len(a) <= 3:
        return 1

    base = a[-1]
    m = 10 ** 10
    diff_list = []
    for i in range(len(a) - 2, -1, -1):
        if a[i] >= base:
            diff_list.append(base - m)
            base = a[i]
            m = 10 ** 10
        m = min(m, a[i])
    else:
        diff_list.append(base - m)

    return diff_list.count(max(diff_list))


def main():
    n, t = map(int, input().split())
    a = list(map(int, input().split()))

    print(solve2(a))


if __name__ == '__main__':
    main()
