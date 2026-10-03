from collections import Counter

gp = Counter(input())
n = sum(gp.values())

print(n // 2 - gp["p"])
