from collections import defaultdict


def main():
    N, L = map(int, input().split())
    S_list = [input() for _ in range(N)]
    print("".join(sorted(S_list)))


if __name__ == '__main__':
    main()
