#!/usr/local/bin/python3.5 -tt

import fractions
import random
import sys

if __name__ == '__main__':
    def _(f):
        for l in f:
            for i in l.split():
                yield int(i)

    g = _(sys.stdin)

    N = next(g)

    lcm = 1

    for i in range(N):
        T = next(g)

        lcm = lcm * T // fractions.gcd(lcm, T)

    print(lcm)
