from collections import defaultdict
from itertools import product


def main():
    N = int(input())
    print(*sorted(["".join(s) for s in product("abc", repeat=N)]), sep="\n")


if __name__ == '__main__':
    main()
