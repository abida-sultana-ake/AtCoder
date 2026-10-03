from collections import Counter

S = input()
c = Counter(S)

odd = sum(1 for i in c if c[i]%2 == 1)
pair = sum(c[i]//2 for i in c)

if odd > 0:
    print(1 + pair//odd * 2)
else:
    print(len(S))