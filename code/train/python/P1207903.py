import collections
n = int(input())
s = [input() for _ in range(n)]

chrs = [collections.Counter(s_) for s_ in s]

result = ''

for al in 'abcdefghijklmnopqrstuvwxyz':
    if all([al in chrs_ for chrs_ in chrs]):
        result += min([chrs_[al] for chrs_ in chrs])*al
print(result)