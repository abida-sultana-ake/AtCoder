# -*- coding: utf-8 -*-
"""
http://abc068.contest.atcoder.jp/tasks/arc079_a
AC
"""

def solve(routes, N):
    result = 'IMPOSSIBLE'
    to_middle = set()           #  島1から渡ることのできる島
    from_middle = set()         #  島Nへ渡ることのできる島
    for f, t in routes:
        if f == 1:
            to_middle.add(t)
        elif t == N:
            from_middle.add(f)

    if to_middle & from_middle:
        result = 'POSSIBLE'
    return result



def main():
    N, M = map(int, input().split())
    routes = []
    for _ in range(M):
        routes.append([int(x) for x in input().split()])
    result = solve(routes, N)
    print(result)


if __name__ == '__main__':
    # main()

    to_middle = set()           #  島1から渡ることのできる島
    from_middle = set()         #  島Nへ渡ることのできる島
    N, M = map(int, input().split())
    for _ in range(M):
        f, t = map(int, input().split())
        if f == 1:
            to_middle.add(t)
        elif t == N:
            from_middle.add(f)

    if to_middle & from_middle:
        print('POSSIBLE')
    else:
        print('IMPOSSIBLE')


