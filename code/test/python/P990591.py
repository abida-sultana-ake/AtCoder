# coding: utf-8
"""Snuke's Coloring 2 (ABC Edit)

@author: hijiri.n
@modified: 11-19-2016

"""

def data(): return list(map(int, input().split()))


def solve(init, point):
    w, h, N = init
    rect = [0, w, 0, h]

    for p in point:
        x, y, a = p

        if [1, -1][a % 2] * ([x, y][a > 2] - rect[a - 1]) < 0:
            rect[a - 1] = [x, y][a > 2]

        if rect[1] <= rect[0] or rect[3] <= rect[2]:
            return 0
        
    return (rect[1] - rect[0]) * (rect[3] - rect[2])

# Input init & points data
i_in = data()
p_in = [data() for _ in range(i_in[-1])]
print(solve(i_in, p_in))