import collections
n = input()
a = list(map(int, input().split()))
s = collections.Counter(a);
res = 0
for i in range(10 ** 5 + 1):
    b = 0
    if i in s:
        b += s[i]
    if i - 1 in s:
        b += s[i - 1]
    if i + 1 in s:
        b += s[i + 1]
    res = max(res, b)
print(res)
