from collections import Counter
n = int(input())
s = []
for i in range(n):
    s.append(input())
print(Counter(s).most_common(1)[0][0])
