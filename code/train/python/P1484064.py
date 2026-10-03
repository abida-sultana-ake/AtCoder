s = input()
r = []
for c in 'ABCDEF':
 r.append(sum(1 for x in s if x==c))
print(' '.join(map(str, r)))