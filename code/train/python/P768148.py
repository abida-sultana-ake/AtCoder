# coding: utf-8


if __name__ == '__main__':
    a, b, c = [int(i) for i in input().split(' ')]
    print(c // min(a, b))