import sys
import string
import math

def length(x, y):
    return math.sqrt(pow(x, 2) + pow(y, 2))

def main():
    # A
    # x, y = map(int, input().split())
    #
    # if x >= y:
    #     print(x)
    # else:
    #     print(y)

    # B
    # result = input().translate(str.maketrans("", "", "aiueo"))
    # print(result)

    # C
    ax, ay, bx, by, cx, cy = map(int, input().split())

    a = length((ax - bx), (ay - by))
    b = length((ax - cx), (ay - cy))
    c = length((bx - cx), (by - cy))

    s = (a + b + c)/2

    result = math.sqrt(s*(s - a)*(s - b)*(s - c))
    print(result)


if __name__ == '__main__':
    main()
