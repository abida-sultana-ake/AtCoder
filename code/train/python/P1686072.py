def solve():
    N, M = map(int, input().split())
    edges = [[] for _ in [0] * N]
    for _ in [0] * M:
        a, b = map(int, input().split())
        edges[a - 1].append(b - 1)
        edges[b - 1].append(a - 1)
    print(len(get_lowlink(edges)[0]))


def get_lowlink(edges):
    n = len(edges)
    order = [-1] * n
    low = [float("inf")] * n
    bridges = []
    articulations = [0] if len(edges[0]) > 1 else []
    append_bridge, append_articulation = bridges.append, articulations.append

    def dfs(v, prev, k):
        order[v] = low[v] = k

        is_articulation = False
        for dest in edges[v]:
            if order[dest] == -1:
                dfs(dest, v, k + 1)
                if low[v] > low[dest]:
                    low[v] = low[dest]
                if order[v] < low[dest]:
                    append_bridge((v, dest))
                is_articulation |= order[v] <= low[dest]

            elif dest != prev and low[v] > order[dest]:
                low[v] = order[dest]

        if v > 0 and is_articulation:
            append_articulation(v)

    dfs(0, 0, 0)
    return bridges, articulations


if __name__ == "__main__":
    solve()