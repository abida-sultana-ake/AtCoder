from collections import Counter

N = int(input())
data = []
for i in range(N):
    data.append(input())

counter = Counter(data)

print(counter.most_common()[0][0])
