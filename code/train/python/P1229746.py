from collections import Counter

S = [list(input()) for _ in range(int(input()))]
S_ = [Counter(s) for s in S]
S__ = [set(s.keys()) for s in S_]

res = S__[0]
for s in S__:
    res = res.intersection(s)

ans = {s: 0 for s in res}
for s in res:
    ans_ = min(s_[s] for s_ in S_)
    ans[s] = ans_

anss = list()
for s, v in ans.items():
    anss.append(s*v)

print(''.join(sorted(anss)))
