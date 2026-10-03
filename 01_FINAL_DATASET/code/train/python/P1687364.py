#DEBUG = ""


def _p(*obj):
    if "DEBUG" not in globals():
        return
    import inspect
    l = inspect.stack()[1].lineno
    print("[{}]: ".format(l), end='')
    from pprint import pprint
    pprint(*obj)


def isConnected(edges):
    _p(edges)
    nodes_from = []
    for n in range(N):
        nodes_from.append(
            [e[1] if e[0] == n else e[0] for e in edges if n in e]
        )
    _p(nodes_from)

    visited_nodes = set()
    next_nodes = set([0])
    while len(next_nodes) != 0:
        visited_nodes |= set(next_nodes)
        new_next_nodes = set()
        for n in next_nodes:
            new_next_nodes |= set(nodes_from[n])
        next_nodes = new_next_nodes - visited_nodes
    _p(visited_nodes)
    return len(visited_nodes) == N


def main():
    global N, M
    N, M = [int(i) for i in input().split()]
    edges = []
    for m in range(M):
        edges.append([int(i) - 1 for i in input().split()])

    count = 0
    for m in range(M):
        es = edges[:]
        es.pop(m)
        if not isConnected(es):
            count += 1
    print(count)


if __name__ == "__main__":
    main()
