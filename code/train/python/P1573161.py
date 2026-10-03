from collections import defaultdict
def read(): return list(map(int, input().split()))


n = int(input())
a = read()

cnt = defaultdict(int)
for i in a:
    cnt[i - 1] += 1
    cnt[i] += 1
    cnt[i + 1] += 1

print(max(cnt.values()))