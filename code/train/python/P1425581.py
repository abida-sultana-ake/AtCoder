import sys
from collections import deque

cin = sys.stdin
# cin = open("in.txt", "r")

def line2N():
    return map(int, cin.readline().split())


N, = line2N()
adj = [[] for i in range(N+1)]
for i in range(N-1):
    u, v = line2N()
    adj[u].append(v)
    adj[v].append(u)

color = [0]*(N+1)
h_cnt = 1
t_cnt = 1
dq_head = deque([1])
color[1] = 1
dq_tail = deque([N])
color[N] = 1
for step in range(N):
    if step % 2==0:
        if not dq_head:
            t_cnt = N - h_cnt
            break
        dq_head_n = deque()
        for u in dq_head:
            for v in adj[u]:
                if color[v]==0:
                    color[v] = 1
                    dq_head_n.append(v)
                    h_cnt += 1
        dq_head = dq_head_n

    else:
        if not dq_tail:
            h_cnt = N - t_cnt
            break
        dq_tail_n = deque()
        for u in dq_tail:
            for v in adj[u]:
                if color[v]==0:
                    color[v] = 2
                    dq_tail_n.append(v)
                    t_cnt += 1
        dq_tail = dq_tail_n

# print(h_cnt, t_cnt)
if h_cnt > t_cnt:
    print("Fennec")
else:
    print("Snuke")

