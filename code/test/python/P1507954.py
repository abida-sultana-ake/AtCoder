from queue import deque

n = int(input())
edges = [set() for _ in range(n + 1)]
for _ in range(n - 1):
    a, b, c = map(int, input().split())
    edges[a].add((c, b))
    edges[b].add((c, a))
q, k = map(int, input().split())
stack = deque([(0, k)])
costs = [0] * (n + 1)
visited = set()
while stack:
    c, p = stack.popleft()
    costs[p] = c
    visited.add(p)
    stack.extend((c + c2, p2) for c2, p2 in edges[p] if p2 not in visited)

ans = []
for _ in range(q):
    x, y = map(int, input().split())
    ans.append(costs[x] + costs[y])
print('\n'.join(map(str, ans)))
