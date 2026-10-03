import copy

from collections import deque


def check(s):
    que = deque()
    que.append(s)
    while len(que) != 0:
        tmp_ele = que.pop()
        flgs[tmp_ele] = True
        for ele in tmp_G[tmp_ele]:
            if not flgs[ele]:
                que.append(ele)

    for flag in flgs:
        if not flag:
            return False
    else:
        return True


if __name__ == '__main__':
    N, M = map(int, input().split())
    graph_list = []

    for i in range(M):
        tmp_a, tmp_b = map(int, input().split())
        graph_list.append((tmp_a, tmp_b))

    G = [[] for _ in range(N + 1)]
    for a, b in graph_list:
        G[a].append(b)
        G[b].append(a)

    ans = 0

    for a, b in graph_list:
        tmp_G = copy.deepcopy(G)
        tmp_G[a].remove(b)
        tmp_G[b].remove(a)
        flgs = [False for _ in range(N + 1)]
        flgs[0] = True
        if not check(1):
            ans += 1

    print(ans)