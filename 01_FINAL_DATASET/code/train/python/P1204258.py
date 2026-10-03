# -*- coding: utf-8 -*-


def main(n, D):
    D = set(D)
    while set(str(n)) & D:
        n += 1
    return n


if __name__ == '__main__':
    n, _ = [int(e) for e in input().split()]
    D = [e for e in input().split()]
    print(main(n, D))