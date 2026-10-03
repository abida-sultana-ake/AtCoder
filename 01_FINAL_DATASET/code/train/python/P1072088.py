from collections import deque


def create_group(N, n):
    city = [[] for _ in range(N + 1)]
    for _ in range(n):
        p, q = map(int, input().split(" "))
        city[p].append(q)
        city[q].append(p)

    group_list = [0] * (N + 1)
    gid = 0
    Q = deque()
    for i in range(1, N + 1):
        if group_list[i] == 0:
            gid += 1
            Q.clear()
            Q.append(i)
            group_list[i] = gid
            while len(Q) > 0:
                x = Q.popleft()
                for y in city[x]:
                    if group_list[y] == 0:
                        group_list[y] = gid
                        Q.append(y)

    return group_list

if __name__ == "__main__":
    N, K, L = list(map(int, input().split(" ")))
    rg = create_group(N, K)
    lg = create_group(N, L)

    rg_lg_dict = {}
    for i in range(1, N+1):
        key = (rg[i], lg[i])
        if key in rg_lg_dict:
            rg_lg_dict[key] += 1
        else:
            rg_lg_dict[key] = 1

    print_list = []
    for i in range(1, N+1):
        key = (rg[i], lg[i])
        print_list.append(str(rg_lg_dict[key]))
    print(" ".join(print_list))
