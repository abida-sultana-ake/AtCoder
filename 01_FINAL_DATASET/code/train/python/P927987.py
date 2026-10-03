import re
import doctest


class IO_for_Contest(object):
    @staticmethod
    def my_input():
        # return raw_input()
        return input()

    @staticmethod
    def read_from_input():
        return IO_for_Contest.read_n_int(2)

    @staticmethod
    def read_line():
        return IO_for_Contest.my_input().strip()

    @staticmethod
    def read_int():
        return int(IO_for_Contest.my_input().strip())

    @staticmethod
    def read_n_int(n):
        return list(map(
                    int,
                    re.split('\s+', IO_for_Contest.my_input().strip())))[: n]


def solve():
    buf = IO_for_Contest.read_from_input()
    n = buf[0]
    k = buf[1]
    print(k * ((k - 1) ** (n - 1)))


if __name__ == '__main__':
    # doctest.testmod()
    solve()