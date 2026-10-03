import collections
import string

n = int(input())
s = []
for i in range(n):
    s.append(collections.Counter(input()))
ret = ''
for i in string.ascii_lowercase:
    ret += i * min([c[i] for c in s])
print(ret)
