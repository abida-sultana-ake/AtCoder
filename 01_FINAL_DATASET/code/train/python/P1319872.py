import itertools
for i in itertools.product('abc', repeat=int(input())):print(''.join(i))