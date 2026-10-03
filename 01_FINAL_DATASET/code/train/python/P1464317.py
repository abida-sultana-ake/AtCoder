# coding: utf-8

if __name__ == "__main__":
    n, m = map(int, input().split())

    connected_1 = []
    connected_n = []

    for _ in range(m):
        a, b = map(int, input().split())
        if a == 1:
            connected_1.append(b)
            continue
        elif a == n:
            connected_n.append(b)
            continue
        elif b == 1:
            connected_1.append(a)
            continue
        elif b == n:
            connected_n.append(a)
            continue
        else:
            continue

    if len(set(connected_1).intersection(set(connected_n))) >= 1:
        print('POSSIBLE')
    else:
        print('IMPOSSIBLE')
