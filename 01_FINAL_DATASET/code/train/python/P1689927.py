#!/usr/bin/python3

n, m = list(map(int, input().split()))
br = []
r = {}
for i in range(m):
    a, b = input().split()
    br.append((a, b))
    try:
        r[a].append(b)
    except KeyError:
        r[a] = []
        r[a].append(b)
    try:
        r[b].append(a)
    except KeyError:
        r[b] = []
        r[b].append(a)

done = {}

def s(node):
    if done[node] == 1:
        return
    done[node] = 1
    for i in r[node]:
        if node in down and i in down:
            continue
        s(i)

def chk():
    for i in r.keys():
        done[i] = 0
    s('1')
    for i in done.keys():
        if done[i] == 0:
            return False
    return True

nbr = 0
for i in br:
    down = i
    if chk() == False:
        nbr += 1

print(nbr)