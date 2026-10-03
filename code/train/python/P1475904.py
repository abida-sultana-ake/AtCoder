from collections import Counter
from itertools import product

N, W = map(int,input().split())
w2vl = {}
lw = []

for i in range(N):
    w, v = map(int, input().split())
    lw.append(w)
    if w2vl.get(w, None) is None:
        w2vl[w] = []
    w2vl[w].append(v)
    w2vl[w] = sorted(w2vl[w],reverse=True)

ct = Counter(lw)

args = []
ws = []
for w in range(lw[0], lw[0]+4):
    if ct[w] == 0: continue
    args.append(range(ct[w]+1))
    ws.append(w)

a = 0
for i in product(*args):
    w = sum(map(lambda x: x[0] * x[1] ,zip(i,ws)))
    if 1 > w or w > W: continue
    v = sum([sum(w2vl[k][:j]) for j,k in zip(i,ws)])
    if a < v:
        a = v

print(a)