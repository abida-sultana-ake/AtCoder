import collections

n = int(input())

d = collections.defaultdict(list)

for _ in range(n - 1):
    u, v = map(int, input().split())
    d[u].append(v)
    d[v].append(u)

bw = collections.defaultdict(str)

bw[1] = 'b'
bw[n] = 'w'

q = collections.deque()
q.append(1)
q.append(n)

fennec = 0
snuke = 0

while True:
    if len(q) == 0:
        break

    t = q.popleft()

    if bw[t] == 'b':
        fennec += 1
    if bw[t] == 'w':
        snuke += 1

    for succ in d[t]:
        if bw[succ] == '':
            bw[succ] = bw[t]
            q.append(succ)

if fennec > snuke:
    print('Fennec')
else:
    print('Snuke')
