#!/usr/bin/env python


def make_relation_map():
    N, M = map(int, input().split())
    relation_map = [[0 for i in range(N)] for j in range(N)]
    for i in range(M):
        x, y = map(int, input().split())
        relation_map[x - 1][y - 1] = 1
        relation_map[y - 1][x - 1] = 1

    return N, M, relation_map


def make_candidate(N, i):
    binary = bin(i)
    candidate = [int(i) for i in list(binary[2:].zfill(N))]
    return candidate


def check(N, relation_map, candidate):
    flag = True
    counter = 0
    for i in range(N - 1):
        if candidate[i] == 0:
            pass
        else:
            for j in range(i + 1, N):
                if candidate[j] == 0:
                    pass
                else:
                    flag = True if relation_map[i][j] == 1 else False
                if flag == False:
                    break
            if flag == False:
                break

    if flag == False:
        return counter
    else:
        for i in range(N):
            if candidate[i] == 1:
                counter += 1
        return counter


def main():
    N, M, relation_map = make_relation_map()
    member = 0
    for i in range(2 ** N):
        candidate = make_candidate(N, i)
        counter = check(N, relation_map, candidate)
        member = member if member > counter else counter
    print(member)

if __name__ == '__main__':
    main()
