import heapq
n = int(input())
p = []
q = []
for i in range(n):
    x,y = map(int, input().split())
    p.append((x, y, i))
    q.append((y, x, i))

p.sort()
q.sort()
pid = [0 for i in range(n)]
qid = [0 for i in range(n)]
for i in range(n):
    pid[p[i][2]] = i
    qid[q[i][2]] = i
used = [False] * n

total = 0

hq = [(0, 0)]
cnt = 0
s = set()
while hq and cnt < n:
    c, i = heapq.heappop(hq)
    # print(c, i)
    if i not in s:
        cnt += 1
        s.add(i)
        total += c
    else:
        continue
    pi = pid[i]
    qi = qid[i]
    if pi > 0 and p[pi-1][2] not in s:
        heapq.heappush(hq, (p[pi][0] - p[pi-1][0], p[pi-1][2]))
    if pi < n-1 and p[pi+1][2] not in s:
        heapq.heappush(hq, (p[pi+1][0] - p[pi][0], p[pi+1][2]))
    if qi > 0 and q[qi-1][2] not in s:
        heapq.heappush(hq, (q[qi][0] - q[qi-1][0], q[qi-1][2]))
    if qi < n-1 and q[qi+1][2] not in s:
        heapq.heappush(hq, (q[qi+1][0] - q[qi][0], q[qi+1][2]))
    
        

print(total)