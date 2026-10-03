# coding: utf-8


def is_arrange(d1, d2):
    return any(d in d1 for d in d2)


if __name__ == '__main__':
    display1 = [int(i) for i in input().split(' ')]
    display2 = [int(i) for i in input().split(' ')]
    print('YES' if is_arrange(display1, display2) else 'NO')