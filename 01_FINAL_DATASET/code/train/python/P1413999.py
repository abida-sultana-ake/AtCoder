from collections import defaultdict


def main():
    A, B, C = map(int, input().split())
    print("Yes" if A <= C <= B else "No")


if __name__ == '__main__':
    main()
