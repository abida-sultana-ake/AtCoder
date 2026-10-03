from collections import Counter

N = int(input())
names = [input() for i in range(N)]
names_counter = Counter(names)
ans = names_counter.most_common(1)

print(ans[0][0])