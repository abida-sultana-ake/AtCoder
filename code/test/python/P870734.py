from collections import Counter
w = input()
cnt = Counter()
for word in w:
    cnt[word] += 1
v = list(cnt.values())
if sum([v[i] %2 for i in range(len(cnt))]) == 0:
    print("Yes")
else:
    print("No")