import sys

sys.setrecursionlimit(10 ** 5 + 100)

# sys.stdin = open('d1.in')


def read_int_list():
    return list(map(int, input().split()))


def read_int():
    return int(input())


def read_str_list():
    return input().split()


def read_str():
    return input()


adj = []
p = []
state = []


def dfs(root, parent):
    state[root] = 1
    p[root] = parent
    for i in adj[root]:
        if i != parent:
            dfs(i, root)
    state[root] = 2


def get_size(root):
    res = 1
    for i in adj[root]:
        if i != p[root]:
            res += get_size(i)
    return res


def solve():
    global adj
    global p
    global state
    n = read_int()
    pairs = [read_int_list() for i in range(n - 1)]
    adj = [[] for i in range(n)]
    for x, y in pairs:
        x -= 1
        y -= 1
        adj[x].append(y)
        adj[y].append(x)
    state = [0] * n
    p = [-1] * n
    dfs(0, -1)

    j = n - 1
    q = []
    while j != 0:
        q.append(j)
        j = p[j]
    q.append(0)

    lq = len(q)
    half = lq // 2

    s = get_size(q[half - 1])
    if n - s > s:
        return 'Fennec'
    return 'Snuke'


def main():
    res = solve()
    print(res)


if __name__ == '__main__':
    main()
