from collections import defaultdict
from itertools import product
from math import pi

MOD = 10 ** 9 + 7


def main():
    A, B, C = int(input()), int(input()), int(input())
    AB = (A * B) % MOD
    BC = (B * C) % MOD
    CA = (C * A) % MOD
    c = ((BC - AB) * pow((CA - BC + AB), MOD - 2, MOD)) % MOD
    r = ((BC - CA) * pow((AB - BC + CA), MOD - 2, MOD)) % MOD

    print(r, c)


if __name__ == '__main__':
    main()
