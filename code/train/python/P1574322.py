from collections import Counter
from itertools import product

N, W = map(int, input().split())
items = {}
weight = []

for i in range(N):
    w, v = map(int, input().split())
    weight.append(w)
    
    if items.get(w, None) is None:
        items[w] = []
    items[w].append(v)
    items[w] = sorted(items[w], reverse = True)

cnt = Counter(weight)

w_num = [] #各重さの個数。組み合わせのために使う。[range(0,2), range(0,3), range(0,2)]のような出力
w_set = [] # 重さは w0 <= wi <= w0+3の４通りしかない

for w in range(weight[0], weight[0] + 4):
    if cnt[w] == 0:
        continue
    
    w_num.append(range(cnt[w] + 1))
    w_set.append(w)

ans = 0

for i in product(*w_num):
    w = sum(map(lambda x: x[0] * x[1], zip(i, w_set)))
    if 1 > w or w > W:
        continue
    v = sum([sum(items[k][:j]) for j, k in zip(i, w_set)])
    if ans < v:
        ans = v

print(ans)