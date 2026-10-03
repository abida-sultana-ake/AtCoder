#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""042-c"""

import sys


def solve(dislike_digits_table, first_like_digit, N):
    """Solve."""
    for i, _ in enumerate(N):
        c = N[i]
        while dislike_digits_table[int(c)]:
            if c == '9':
                if i == 0:
                    return solve(dislike_digits_table,
                                 first_like_digit,
                                 '1' + '0' * len(N))
                else:
                    return solve(dislike_digits_table,
                                 first_like_digit,
                                 str(int(N[0:i+1]) + 1)
                                    + '0' * len(N[i+1:]))
            else:
                c = chr(ord(c) + 1)
            N = N[0:i] + c + '0' * len(N[i+1:])

    return N


def main():
    """Main function."""
    dislike_digits_table = [False for _ in range(10)]

    N, _ = sys.stdin.readline().split(' ')
    digits = map(int, sys.stdin.readline().split(' '))

    for digit in digits:
        dislike_digits_table[digit] = True

    first_like_digit = str(next(i for i, v
                                in enumerate(dislike_digits_table)
                                if not v))

    print(solve(dislike_digits_table, first_like_digit, N))


if __name__ == '__main__':
    sys.exit(main())