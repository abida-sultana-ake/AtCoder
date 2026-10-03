from collections import Counter

input()
cnt = Counter(input().strip() + '1234').values()
print(max(cnt) - 1, min(cnt) - 1)
