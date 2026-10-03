from collections import Counter
n = int(input())
chrs = set()
cnt = []
for i in range(n):
    s = input()
    cnt.append(Counter(s))
    for c in s:
        chrs.add(c)
ans = ''
for c in sorted(list(chrs)):
    size = cnt[0][c]
    for i in range(1, n):
        size = min(size, cnt[i][c])
    ans += c * size
print(ans)
