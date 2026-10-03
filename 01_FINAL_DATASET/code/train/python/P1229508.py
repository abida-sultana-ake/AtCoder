import collections

n = int(input())
cur = collections.Counter(input())
for i in range(n - 1):
    cur &= collections.Counter(input())
    if not cur: break
seq = []
for char in sorted(cur):
    seq.append(char * cur[char])
res = ''.join(seq)
print(res)