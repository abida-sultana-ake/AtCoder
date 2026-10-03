from collections import Counter

n = int(input().rstrip())
counter = Counter(map(int, input().rstrip().split(' ')))

x = y = 0
for k, v in counter.items():
    if v >= 2 and k > y:
        if k >= x:
            if v >= 4:
                x = y = k
            else:
                x, y = k, x
        else:
            y = k

print(x * y)