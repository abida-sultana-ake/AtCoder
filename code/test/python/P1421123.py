from collections import Counter
N = int(input())
array = []
count = 0
for i in range(N):
    M = int(input())
    array.append(M)
c = Counter(array)
ans = c.most_common()
for i, a in ans:
    if a > 1:
        count += (a - 1)
print(count)
