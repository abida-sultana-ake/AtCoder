import queue
n, m = map(int, input().split())
v = [[] for i in range(n+1)]
for i in range(m):
    a, b = map(int, input().split())
    v[a].append(b)
    v[b].append(a)


result = 0
q = queue.Queue()
q.put([1])
while not q.empty():
    p = q.get()
    if len(p) == n:
        result += 1
    else:
        way = v[p[-1]]
        for i in way:
            if not i in p:
                q.put(p+[i])
print(result)