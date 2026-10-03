d = {'O':'0', 'D':'0', 'I':'1', 'Z':'2', 'S':'5', 'B':'8'}
S = input()
for c in S:
    if c not in d.keys():
        print(c, end='')
    else:
        print(d[c], end='')
print()