from collections import defaultdict


def main():
    S = input()
    items = S.split("+")
    print(sum(1 for item in items if "0" not in item))


if __name__ == '__main__':
    main()
