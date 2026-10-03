def solve():
    n, l = map(int, input().split())
    s = [input() for _ in range(n)]
    s.sort()
    print(''.join(s))


def main():
    solve()


if __name__ == '__main__':
    main()
