import re


class IO_for_Contest(object):
    @staticmethod
    def my_input():
        # return raw_input()
        return input()

    @staticmethod
    def read_from_input():
        # TODO: impl this for each problem
        pass

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
    what = IO_for_Contest.read_line()
    if what[-1] == 'T':
        print('YES')
    else:
        print('NO')


if __name__ == '__main__':
    solve()