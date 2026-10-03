from collections import Counter

n = int(input())
c = []
for _ in range(n):
    line = list(input())
    c.append(Counter(line))

ansc = c[0]
for i in range(n-1):
    ansc = ansc & c[i+1]

for i in range(97, 97+26):
    if ansc[chr(i)] > 0:
        print(chr(i)*ansc[chr(i)], end="")