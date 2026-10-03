from collections import Counter

N = int(input())
S = [input() for _ in range(N)]

counter = Counter(S).most_common(1)
print(counter[0][0])