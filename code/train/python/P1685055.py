#!/usr/bin/env python3

bridges = 0

def visit(i, cnt, frm):
    global bridges

    cnt += 1

    pre[i] = cnt
    low[i] = cnt

    for n in e[i]:
        if pre[n] == -1:
            low[i] = min(low[i], visit(n, cnt, i))
            if low[n] == pre[n]:
                bridges += 1
        elif n != frm:
            low[i] = min(low[i], low[n])

    return low[i]

n, m = [int(x) for x in input().split()]
e = [set() for _ in range(n)]
for _ in range(m):
    p, q = [int(x) - 1 for x in input().split()]
    e[p].add(q)
    e[q].add(p)

pre = [-1 for _ in range(n)]
low = [-1 for _ in range(n)]

visit(0, 0, -1)
print(bridges)
