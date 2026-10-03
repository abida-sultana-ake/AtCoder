from collections import Counter

w = input()

c = Counter(w)

for _, v in c.items():
    if v % 2 != 0:
        print('No')
        break
else:
    print('Yes')
