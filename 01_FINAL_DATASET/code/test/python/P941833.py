import collections
s = input()
cs = dict(collections.Counter(s))
ans = 0
one = 0
for c in cs:
    ans += cs[c] // 2
    one += cs[c] % 2

ans = 1 + 2*(ans//one) if one else 2*ans
print(ans)


