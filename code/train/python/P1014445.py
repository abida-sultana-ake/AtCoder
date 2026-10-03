import itertools
total = 0
s = input()
for t in itertools.product(['', '+'], repeat=len(s) - 1):
    total += eval(''.join(c1 + c2 for c1, c2 in zip(s, t)) + s[-1])
print(total)