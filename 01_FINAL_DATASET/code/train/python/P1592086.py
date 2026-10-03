# -*- coding: utf-8 -*-
"""
http://abc066.contest.atcoder.jp/tasks/arc077_a

"""
import sys
from sys import stdin
input = stdin.readline



def main(args):
    n = int(input())
    a = [int(x) for x in input().split()]

    #b = []
    #for i in range(1, n+1):
    #    b.append(a[i-1])
    #    b.reverse()
    #print(*b)

    l = len(a)
    b = [0] * l
    pos = l // 2
    if l % 2 == 1:
        direction = 1
    else:
        direction = -1

    step = 1
    for c in a:
        # print('pos: {}, step: {}, direction: {}'.format(pos, step, direction))
        b[pos] = c
        pos = pos + (step * direction)
        step += 1
        direction *= -1
        # print(*b)
    print(*b)



if __name__ == '__main__':
    main(sys.argv[1:])